package com.exadel.mooc.mapper;

import com.exadel.mooc.repository.ILessonRepository;
import com.exadel.mooc.dto.LessonItemDTO;
import com.exadel.mooc.entity.LessonsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LessonItemMapper {

    @Autowired
    private ILessonRepository lessonRepository;

    public LessonItemDTO toDTO(LessonsItem lessonItem) {
        return LessonItemDTO.builder()
                .name(lessonItem.getName())
                .order(lessonItem.getOrder())
                .content(lessonItem.getContent())
                .title_img_link(lessonItem.getTitle_img_link())
                .lessonId(lessonItem.getLesson().getId())
                .build();
    }

    public LessonsItem toEntity(LessonItemDTO lessonItemDTO) {
        return LessonsItem.builder()
                .name(lessonItemDTO.getName())
                .order(lessonItemDTO.getOrder())
                .content(lessonItemDTO.getContent())
                .title_img_link(lessonItemDTO.getTitle_img_link())
                .lesson(lessonRepository.findById(lessonItemDTO.getLessonId())
                        .orElseThrow(() -> new RuntimeException("lesson item mapper error")))
                .build();
    }
}
