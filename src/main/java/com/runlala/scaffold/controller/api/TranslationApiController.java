package com.runlala.scaffold.controller.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.runlala.scaffold.config.SiteConfig;
import com.runlala.scaffold.dto.http.Language;
import com.runlala.scaffold.dto.http.WordTranslation;
import com.runlala.scaffold.util.HttpClientUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/translation")
@Tag(name = "Translation API")
@AllArgsConstructor
public class TranslationApiController {
    private final SiteConfig siteConfig;

    @GetMapping("/translate")
    public WordTranslation translate(@RequestParam String text,
                                     @RequestParam String toLang) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        return HttpClientUtil.get(
                siteConfig.getTranslatorBaseUrl() + siteConfig.getTranslatorTranslatePath(),
                Map.of("text", text, "to_lang", toLang),
                siteConfig.getTranslatorApiKey(),
                new TypeReference<>() {});
    }

    @GetMapping("/languages")
    public List<Language> languages() throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        return HttpClientUtil.get(
                siteConfig.getTranslatorBaseUrl() + siteConfig.getTranslatorLanguagesPath(),
                null,
                siteConfig.getTranslatorApiKey(),
                new TypeReference<>() {});
    }

    @GetMapping(value = "/audio", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> audio(@RequestParam() String pronunciationId) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        HttpResponse<InputStream> response = HttpClientUtil.getStream(
                siteConfig.getTranslatorBaseUrl() + siteConfig.getTranslatorAudioPath(),
                Map.of("pronunciation_id", pronunciationId),
                siteConfig.getTranslatorApiKey());
        InputStreamResource resource = new InputStreamResource(response.body());

        return ResponseEntity.ok()
                .headers(HttpClientUtil.convertHeaders(response.headers()))
                .body(resource);
    }

}