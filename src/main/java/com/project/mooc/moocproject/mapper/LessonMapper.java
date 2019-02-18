package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dto.LessonDTO;
import com.project.mooc.moocproject.entity.Lesson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LessonMapper {

    @Autowired
    private ModelMapper mapper;

    public Lesson toEntity(LessonDTO lessonDTO) {
        return Objects.isNull(lessonDTO) ? null : mapper.map(lessonDTO, Lesson.class);
    }

    public LessonDTO toDTO(Lesson lesson) {
        return Objects.isNull(lesson) ? null : mapper.map(lesson, LessonDTO.class);
    }
}
