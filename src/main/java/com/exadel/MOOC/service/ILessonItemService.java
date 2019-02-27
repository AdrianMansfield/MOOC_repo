package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.LessonItemDTO;

import java.util.List;

public interface ILessonItemService {

    void save(LessonItemDTO lessonItemDTO);

    void deleteByID(Long id);

    void update(LessonItemDTO lessonItemDTO);

    List<LessonItemDTO> findAll();
}
