package com.runlala.scaffold.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runlala.scaffold.enums.Language;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class TranslatorService {
    private static final String endpoint = "https://api.cognitive.microsofttranslator.com/dictionary/lookup";
    private static final String key = "acb94358b7124e29992d578c73753a00";
    private static final String location = "eastasia";

    public static Map<String, Object> translate(String word, Language language) throws Exception {
        String fromLanguage = "en";
        String toLanguage = language.name().replace("_", "-").toLowerCase(Locale.ROOT);

        URI uri = URI.create(endpoint + "?api-version=3.0&from=" + fromLanguage + "&to=" + toLanguage);

        Map<String, String> headers = new HashMap<>();
        headers.put("Ocp-Apim-Subscription-Key", key);
        headers.put("Ocp-Apim-Subscription-Region", location);
        headers.put("Content-Type", "application/json");
        headers.put("X-ClientTraceId", java.util.UUID.randomUUID().toString());

        String requestBody = "[{\"Text\": \"" + word + "\"}]";

        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .headers( headers.entrySet().stream()
                        .flatMap(e -> Stream.of(e.getKey(), e.getValue()))
                        .toArray(String[]::new)
                )
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(response.body());

        Map<String, Object> translated = new HashMap<>();
        JsonNode translationsNode = jsonResponse.get(0).get("translations");

        for (JsonNode translationNode : translationsNode) {
            String posTag = translationNode.get("posTag").asText();
            String displayTarget = translationNode.get("displayTarget").asText();

            if (!translated.containsKey(posTag)) {
                translated.put(posTag, new ArrayList<>());
            }
            ((List<String>) translated.get(posTag)).add(displayTarget);
        }

        return translated;
    }
}
