package com.runlala.scaffold.dto.out;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookOutDto extends OutDtoBase {
    String name;
    String issued;
    String coverUrl;
    String epubUrl;
    String chapterCount;
    String lang;
}