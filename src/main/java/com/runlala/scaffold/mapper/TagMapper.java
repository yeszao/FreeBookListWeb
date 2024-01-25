package com.runlala.scaffold.mapper;

import com.runlala.scaffold.dto.out.TagOutDto;
import com.runlala.scaffold.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagOutDto toDto(Tag tag);
}