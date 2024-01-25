package com.runlala.scaffold.dto.out;

import com.runlala.scaffold.entity.Author;
import com.runlala.scaffold.entity.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookOutDto extends OutDtoBase {
    String name;
    String issued;
    String coverUrl;
    String epubUrl;
    String chapterCount;
    String lang;
    Author author;
    Set<Tag> tags;
}