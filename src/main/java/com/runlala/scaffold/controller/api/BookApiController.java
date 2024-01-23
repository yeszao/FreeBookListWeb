package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.dto.in.BookInDto;
import com.runlala.scaffold.entity.Author;
import com.runlala.scaffold.entity.Book;
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
public class BookApiController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    @QueryMapping
    public Book getBook(@Argument Long id) {
        return bookRepository.getReferenceById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorRepository.getReferenceById(book.getAuthorId());
    }

    @MutationMapping
    public Book addBook(@Argument BookInDto bookInDto) {
        Book book = bookMapper.toBook(bookInDto);
        return bookRepository.save(book);
    }
}
