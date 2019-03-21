package com.exadel.mooc.converter;

import com.exadel.mooc.dto.LessonDTO;
import com.exadel.mooc.entity.Lesson;
import com.exadel.mooc.exception.EntityNotFoundException;
import com.exadel.mooc.repository.IModuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LessonConverter {

    @Autowired
    private IModuleRepository moduleRepository;


    public Lesson toEntity(LessonDTO lessonDTO) {
        log.info("Convert LessonDTO {} to entity", lessonDTO);
        return Lesson.builder()
                .title(lessonDTO.getTitle())
                .order(lessonDTO.getOrder())
                .module(moduleRepository.findById(lessonDTO.getModuleId())
                        .orElseThrow(() -> new EntityNotFoundException("can not find module by id:" + lessonDTO.getModuleId())))
                .build();
    }

    public LessonDTO toDTO(Lesson lesson) {
        log.info("Convert lesson {} to DTO", lesson);
        return LessonDTO.builder()
                .title(lesson.getTitle())
                .order(lesson.getOrder())
                .moduleId(lesson.getModule().getId())
                .build();
    }
}
