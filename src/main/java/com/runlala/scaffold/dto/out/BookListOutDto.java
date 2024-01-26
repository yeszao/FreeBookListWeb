package com.runlala.scaffold.dto.out;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BookListOutDto {
    Long id;
    String name;
    String coverUrl;
    String lang;
    AuthorOutDto author;
    Set<TagOutDto> tags = new HashSet<>();
}