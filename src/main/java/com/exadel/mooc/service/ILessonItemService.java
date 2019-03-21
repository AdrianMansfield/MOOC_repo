package com.exadel.mooc.service;

import com.exadel.mooc.dto.LessonItemDTO;

import java.util.List;

public interface ILessonItemService {

    void save(LessonItemDTO lessonItemDTO);

    void deleteByID(Long id);

    void update(LessonItemDTO lessonItemDTO);

    List<LessonItemDTO> findAll();

    LessonItemDTO findById(Long id);
}
