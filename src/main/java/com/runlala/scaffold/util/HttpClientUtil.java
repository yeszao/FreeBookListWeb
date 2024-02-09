package com.runlala.scaffold.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class HttpClientUtil {
    static ObjectMapper objectMapper;
    static HttpClient client;

    public static ObjectMapper getObjectMapper () {
        if (Objects.isNull(objectMapper)) {
            objectMapper = new ObjectMapper();
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            objectMapper.enable(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY);
        }
        return objectMapper;
    }

    public static HttpClient getHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        if (Objects.isNull(client)) {
            client = HttpClient.newBuilder().sslContext(sslContext).build();
        }
        return client;
    }

    public static <T> T get(String url, Map<String, String> params, String apiKey, Class<T> responseType) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url + buildParams(params)))
                .GET()
                .header("Accept", "application/json")
                .header("X-API-Key", apiKey)
                .build();
        log.info("Request: {}", request);
        HttpResponse<String> httpResponse = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return getObjectMapper().convertValue(httpResponse.body(), responseType);
    }

    public static <T> List<T> getList(String url, Map<String, String> params, String apiKey, TypeReference<List<T>> responseType) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url + buildParams(params)))
                .GET()
                .header("Accept", "application/json")
                .header("X-API-Key", apiKey)
                .build();
        log.info("Request: {}", request);
        HttpResponse<String> httpResponse = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return getObjectMapper().convertValue(httpResponse.body(), responseType);
    }

    private static final TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
    };

    public static String buildParams(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                    .append("=")
                    .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                    .append("&");
        }
        // Remove trailing '&'
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
