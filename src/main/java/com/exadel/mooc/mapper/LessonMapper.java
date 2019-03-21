package com.exadel.mooc.mapper;

import com.exadel.mooc.repository.IModuleRepository;
import com.exadel.mooc.dto.LessonDTO;
import com.exadel.mooc.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {

    @Autowired
    private IModuleRepository moduleRepository;


    public Lesson toEntity(LessonDTO lessonDTO) {
        return Lesson.builder()
                .title(lessonDTO.getTitle())
                .order(lessonDTO.getOrder())
                .module(moduleRepository.findById(lessonDTO.getModuleId())
                        .orElseThrow(() -> new RuntimeException("lesson mapper error")))
                .build();
    }

    public LessonDTO toDTO(Lesson lesson) {
        return LessonDTO.builder()
                .title(lesson.getTitle())
                .order(lesson.getOrder())
                .moduleId(lesson.getModule().getId())
                .build();
    }
}
