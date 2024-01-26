package com.runlala.scaffold.mapper;

import com.runlala.scaffold.dto.out.AuthorOutDto;
import com.runlala.scaffold.entity.Author;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorOutDto toDto(Author author);

    default Page<AuthorOutDto> pageToDto(Page<Author> page) {
        return page.map(this::toDto);
    }
}