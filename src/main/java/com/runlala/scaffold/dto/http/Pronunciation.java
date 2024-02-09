package com.runlala.scaffold.dto.http;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pronunciation {
    String id;
    String pronunciation;
    String accent;
}
