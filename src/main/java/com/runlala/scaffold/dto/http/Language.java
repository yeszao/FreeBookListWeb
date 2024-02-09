package com.runlala.scaffold.dto.http;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Language {
    String code;
    String name;
    String nativeName;
}
