package com.exadel.MOOC.service.lessonItem;

import com.exadel.MOOC.dto.LessonItemDTO;

import java.util.List;

public interface LessonItemService {

    void save(LessonItemDTO lessonItemDTO);

    void deleteByID(Long id);

    void update(LessonItemDTO lessonItemDTO);

    List<LessonItemDTO> findAll();
}
