package com.runlala.scaffold.dto.filter;

import lombok.Data;

@Data
public class BookFilterDto {
    String name;
    Long authorId;
    Long tagId;
    Boolean mostFamous;
}
