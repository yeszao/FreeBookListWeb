package com.runlala.scaffold.dto.in;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthorInDto {
    @Size(min = 3, max = 20, message = "name length must be between 3 and 20")
    private String name;
}