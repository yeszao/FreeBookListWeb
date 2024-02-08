package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.dto.filter.BookFilterDto;
import com.runlala.scaffold.dto.out.BookListOutDto;
import com.runlala.scaffold.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tool")
@Tag(name = "Tool API")
@AllArgsConstructor
public class ToolApiController {
    private final BookService bookService;

    @PostMapping("/translate")
    public Page<BookListOutDto> getAll(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestBody(required = false) BookFilterDto bookFilterDto) {
        return bookService.getAll(bookFilterDto, page, size);
    }
}