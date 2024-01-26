package com.runlala.scaffold.dto.out;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookListOutDto {
    Long id;
    String name;
    String coverUrl;
    String lang;
    AuthorOutDto author;
    List<TagOutDto> tags = new ArrayList<>();
}