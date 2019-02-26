package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dao.repository.LessonRepository;
import com.project.mooc.moocproject.dto.LessonItemDTO;
import com.project.mooc.moocproject.entity.LessonsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LessonItemMapper {

    @Autowired
    private LessonRepository lessonRepository;

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
