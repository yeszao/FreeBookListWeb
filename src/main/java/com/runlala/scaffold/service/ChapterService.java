package com.runlala.scaffold.service;

import com.runlala.scaffold.dto.out.ChapterOutDto;
import com.runlala.scaffold.entity.Chapter;
import com.runlala.scaffold.mapper.ChapterMapper;
import com.runlala.scaffold.repository.ChapterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ChapterService {
    private final ChapterRepository chapterRepository;
    private final ChapterMapper chapterMapper;

    public List<ChapterOutDto> getChapters(Long bookId) {
        List<Chapter> chapters = chapterRepository.findAllByBookId(bookId);
        return chapterMapper.toOutDto(chapters);
    }

    public ChapterOutDto getChapter(Long chapterId) {
        return chapterMapper.toOutDto(chapterRepository.getReferenceById(chapterId));
    }
}