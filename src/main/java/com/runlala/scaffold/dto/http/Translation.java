package com.runlala.scaffold.dto.http;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Translation {
    String translation;
    Float confidence;
    String posTag;
}
