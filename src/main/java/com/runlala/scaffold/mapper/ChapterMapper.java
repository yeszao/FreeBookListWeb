package com.runlala.scaffold.mapper;

import com.runlala.scaffold.dto.out.ChapterOutDto;
import com.runlala.scaffold.entity.Chapter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChapterMapper {
    ChapterOutDto toOutDto(Chapter chapter);
    List<ChapterOutDto> toOutDto(List<Chapter> chapters);
}