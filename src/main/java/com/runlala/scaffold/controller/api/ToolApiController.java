package com.runlala.scaffold.controller.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.runlala.scaffold.dto.http.Language;
import com.runlala.scaffold.dto.http.WordTranslation;
import com.runlala.scaffold.service.BookService;
import com.runlala.scaffold.service.ChapterService;
import com.runlala.scaffold.util.HttpClientUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tool")
@Tag(name = "Tool API")
@AllArgsConstructor
public class ToolApiController {
    private final BookService bookService;
    private final ChapterService chapterService;
    private final String baseUrl = "https://word.runlala.com";
    private final String translateUrl = baseUrl + "/translate";
    private final String languagesUrl = baseUrl + "/languages";

    private final String apiKey = "d7731619006ccefa3682e918ac6f5ac5";

    @GetMapping("/translate")
    public WordTranslation translate(@RequestParam String text,
                                     @RequestParam String toLang) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        return HttpClientUtil.get(translateUrl, Map.of("text", text, "to_lang", toLang), apiKey, WordTranslation.class);
    }

    @GetMapping("/languages")
    public List<Language> languages() throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        return HttpClientUtil.getList(languagesUrl, null, apiKey, new TypeReference<List<Language>>(){});
    }

}