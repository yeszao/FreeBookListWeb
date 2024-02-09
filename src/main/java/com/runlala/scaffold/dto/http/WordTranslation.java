package com.runlala.scaffold.dto.http;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WordTranslation {
    String word;
    String language;
    String proficiency;
    List<Pronunciation> pronunciations;
    List<Translation> translations;
}
