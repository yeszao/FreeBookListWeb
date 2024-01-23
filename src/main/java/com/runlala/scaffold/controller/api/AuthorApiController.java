package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.dto.in.AuthorInDto;
import com.runlala.scaffold.dto.in.BookInDto;
import com.runlala.scaffold.entity.Author;
import com.runlala.scaffold.entity.Book;
import com.runlala.scaffold.mapper.AuthorMapper;
import com.runlala.scaffold.mapper.BookMapper;
import com.runlala.scaffold.repository.AuthorRepository;
import com.runlala.scaffold.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AuthorApiController {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @MutationMapping
    public Author addAuthor(@Argument AuthorInDto authorInDto) {
        Author author = authorMapper.toAuthor(authorInDto);
        return authorRepository.save(author);
    }
}
