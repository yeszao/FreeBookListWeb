package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.dto.filter.AuthorFilterDto;
import com.runlala.scaffold.dto.out.AuthorOutDto;
import com.runlala.scaffold.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
@Tag(name = "Author API")
@AllArgsConstructor
public class AuthorApiController {
    private final AuthorService authorService;

    @PostMapping("/all")
    public Page<AuthorOutDto> getAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestBody(required = false) AuthorFilterDto authorFilterDto) {
        return authorService.getAll(authorFilterDto, page, size);
    }
}