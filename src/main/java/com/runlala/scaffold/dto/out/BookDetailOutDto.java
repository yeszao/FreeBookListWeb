package com.runlala.scaffold.dto.out;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    List<TagOutDto> tags = new ArrayList<>();
    List<ChapterOutDto> chapters = new ArrayList<>();
}