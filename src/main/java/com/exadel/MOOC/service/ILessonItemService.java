package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.LessonItemDTO;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface ILessonItemService {

    void save(LessonItemDTO lessonItemDTO);

    void deleteByID(Long id);

    void update(LessonItemDTO lessonItemDTO);

    List<LessonItemDTO> findAll();

    LessonItemDTO findById(Long id) throws NotFoundException;
}
