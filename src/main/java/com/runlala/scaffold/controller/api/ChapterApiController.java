package com.runlala.scaffold.controller.api;

import com.runlala.scaffold.dto.out.ChapterOutDto;
import com.runlala.scaffold.service.ChapterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chapter")
@Tag(name = "Chapter API")
@AllArgsConstructor
public class ChapterApiController {
    private final ChapterService chapterService;


    @PostMapping("/{chapterId}")
    public ChapterOutDto getChapter(@PathParam(value = "chapterId") Long chapterId) {
        return chapterService.getChapter(chapterId);
    }
}