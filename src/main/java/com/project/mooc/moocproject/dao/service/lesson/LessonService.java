package com.project.mooc.moocproject.dao.service.lesson;

import com.project.mooc.moocproject.dto.LessonDTO;

import java.util.List;

public interface LessonService {
    void save(LessonDTO lessonDTO);

    void deleteById(Long id);

    void update(LessonDTO lessonDTO);

    List<LessonDTO> findAll();
}
