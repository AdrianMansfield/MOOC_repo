package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.LessonDTO;

import java.util.List;

public interface ILessonService {
    void save(LessonDTO lessonDTO);

    void deleteById(Long id);

    void update(LessonDTO lessonDTO);

    List<LessonDTO> findAll();

    List<LessonDTO> findByModuleId(Long moduleId);
}
