package com.runlala.scaffold.service;

import com.runlala.scaffold.enums.Language;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class TranslatorServiceTest {

    @Test
    void translate() throws Exception {
        Map<String, Object> result = TranslatorService.translate("hello", Language.ZH_HANS);
        Assertions.assertTrue(result.containsKey("translations"));
    }
}