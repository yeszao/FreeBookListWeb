package com.runlala.scaffold.dto.http;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class WordTranslation {
    String word;
    String language;
    String proficiency;
    List<Pronunciation> pronunciations;
    List<Translation> translations;
}
