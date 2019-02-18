package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dto.LessonItemDTO;
import com.project.mooc.moocproject.entity.LessonsItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LessonItemMapper {

    @Autowired
    private ModelMapper modelMapper;

    public LessonItemDTO toDTO(LessonsItem lessonItem) {
        return Objects.isNull(lessonItem) ? null : modelMapper.map(lessonItem, LessonItemDTO.class);
    }

    public LessonsItem toEntity(LessonItemDTO lessonItemDTO) {
        return Objects.isNull(lessonItemDTO) ? null : modelMapper.map(lessonItemDTO, LessonsItem.class);
    }
}
