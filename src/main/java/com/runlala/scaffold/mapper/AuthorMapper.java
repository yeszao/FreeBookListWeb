package com.runlala.scaffold.mapper;

import com.runlala.scaffold.dto.out.AuthorOutDto;
import com.runlala.scaffold.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorOutDto toDto(Author author);
}