package com.runlala.scaffold.mapper;

import com.runlala.scaffold.dto.out.ChapterOutDto;
import com.runlala.scaffold.entity.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChapterMapper {
    @Mapping(target = "audioUrl", source = "originAudioUrl")
    ChapterOutDto toOutDto(Chapter chapter);
    List<ChapterOutDto> toOutDto(List<Chapter> chapters);
}