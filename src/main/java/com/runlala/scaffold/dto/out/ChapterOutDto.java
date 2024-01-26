package com.runlala.scaffold.dto.out;

import lombok.Data;

@Data
public class ChapterOutDto {
    Long id;
    String title;
    String href;
    String audioUrl;
    Integer sort;
}