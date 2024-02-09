package com.runlala.scaffold.dto.http;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Language {
    String code;
    String name;
    String nativeName;
}
