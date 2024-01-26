package com.runlala.scaffold.dto.out;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class BookDetailOutDto {
    Long id;
    String name;
    String issued;
    String coverUrl;
    String epubUrl;
    Integer chapterCount;
    String lang;
    AuthorOutDto author;
    Set<TagOutDto> tags = new HashSet<>();
    List<ChapterOutDto> chapters = new ArrayList<>();
}