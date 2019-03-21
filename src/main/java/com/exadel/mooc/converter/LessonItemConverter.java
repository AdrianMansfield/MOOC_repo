package com.exadel.mooc.converter;

import com.exadel.mooc.dto.LessonItemDTO;
import com.exadel.mooc.entity.LessonsItem;
import com.exadel.mooc.exception.EntityNotFoundException;
import com.exadel.mooc.repository.ILessonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LessonItemConverter {

    @Autowired
    private ILessonRepository lessonRepository;

    public LessonItemDTO toDTO(LessonsItem lessonItem) {
        log.info("Convert lessonItem {} to DTO", lessonItem);
        return LessonItemDTO.builder()
                .name(lessonItem.getName())
                .order(lessonItem.getOrder())
                .content(lessonItem.getContent())
                .titleImgLink(lessonItem.getTitleImgLink())
                .lessonId(lessonItem.getLesson().getId())
                .build();
    }

    public LessonsItem toEntity(LessonItemDTO lessonItemDTO) {
        log.info("Convert lessonItemDTO {} to entity", lessonItemDTO);
        return LessonsItem.builder()
                .name(lessonItemDTO.getName())
                .order(lessonItemDTO.getOrder())
                .content(lessonItemDTO.getContent())
                .titleImgLink(lessonItemDTO.getTitleImgLink())
                .lesson(lessonRepository.findById(lessonItemDTO.getLessonId())
                        .orElseThrow(() -> new EntityNotFoundException("can not find lesson by id:" + lessonItemDTO.getLessonId())))
                .build();
    }
}
