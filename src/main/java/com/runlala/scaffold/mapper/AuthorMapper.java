package com.runlala.scaffold.mapper;

import com.runlala.scaffold.dto.in.AuthorInDto;
import com.runlala.scaffold.dto.in.BookInDto;
import com.runlala.scaffold.entity.Author;
import com.runlala.scaffold.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toAuthor(AuthorInDto authorInDto);
}