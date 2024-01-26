package com.runlala.scaffold.mapper;

import com.runlala.scaffold.config.SiteConfig;
import com.runlala.scaffold.dto.out.BookDetailOutDto;
import com.runlala.scaffold.dto.out.BookListOutDto;
import com.runlala.scaffold.entity.Book;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = SiteConfig.class)
@AllArgsConstructor
public abstract class BookMapper {
    @Mapping(target = "coverUrl", source = "coverUri", qualifiedByName = "completeStaticUrl")
    @Mapping(target = "epubUrl", source = "epubUri", qualifiedByName = "completeStaticUrl")
    public abstract BookDetailOutDto toDetailDto(Book book);

    @Mapping(target = "coverUrl", source = "coverUri", qualifiedByName = "completeStaticUrl")
    public abstract BookListOutDto toListDto(Book book);

    public Page<BookListOutDto> pageToListDto(Page<Book> page) {
        return page.map(this::toListDto);
    }
}