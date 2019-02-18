package com.project.mooc.moocproject.dao.service.lessonItem;

import com.project.mooc.moocproject.dto.LessonItemDTO;

import java.util.List;

public interface LessonItemService {

    void save(LessonItemDTO lessonItemDTO);

    void deleteByID(Long id);

    void update(LessonItemDTO lessonItemDTO);

    List<LessonItemDTO> findAll();
}
