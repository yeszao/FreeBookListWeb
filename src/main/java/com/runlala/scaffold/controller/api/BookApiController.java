package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.dto.out.BookOutDto;
import com.runlala.scaffold.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
@Tag(name = "Book API")
@AllArgsConstructor
public class BookApiController {
    private final BookService bookService;

    @GetMapping("/all")
    public Page<BookOutDto> getAll(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        return bookService.getAll(page, size);
    }
}