package com.runlala.scaffold.service;

import com.runlala.scaffold.dto.out.BookOutDto;
import com.runlala.scaffold.entity.Book;
import com.runlala.scaffold.mapper.BookMapper;
import com.runlala.scaffold.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Page<BookOutDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = bookRepository.findAll(pageable);
        return bookMapper.pageToDto(books);
    }
}