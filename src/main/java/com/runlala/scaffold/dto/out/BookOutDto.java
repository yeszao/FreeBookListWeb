package com.runlala.scaffold.dto.out;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BookOutDto {
    Long id;
    String name;
    String issued;
    String coverUrl;
    String epubUrl;
    Integer chapterCount;
    String lang;
    AuthorOutDto author;
    Set<TagOutDto> tags = new HashSet<>();
}