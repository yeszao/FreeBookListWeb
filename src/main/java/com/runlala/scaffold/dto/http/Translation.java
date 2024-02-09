package com.runlala.scaffold.dto.http;

import lombok.Data;

@Data
public class Translation {
    String translation;
    Float confidence;
    String posTag;
}
