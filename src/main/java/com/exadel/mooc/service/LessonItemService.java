package com.exadel.mooc.service;

import com.exadel.mooc.converter.LessonItemConverter;
import com.exadel.mooc.dto.LessonItemDTO;
import com.exadel.mooc.exception.EntityNotFoundException;
import com.exadel.mooc.repository.ILessonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonItemService implements ILessonItemService {

    @Autowired
    private ILessonItemRepository lessonItemRepository;

    @Autowired
    private LessonItemConverter lessonItemConverter;

    @Override
    public void save(LessonItemDTO lessonItemDTO) {
        lessonItemRepository.save(lessonItemConverter.toEntity(lessonItemDTO));
    }

    @Override
    public void deleteByID(Long id) {
        lessonItemRepository.deleteById(id);
    }

    @Override
    public void update(LessonItemDTO lessonItemDTO) {
        lessonItemRepository.save(lessonItemConverter.toEntity(lessonItemDTO));
    }

    @Override
    public List<LessonItemDTO> findAll() {
        return lessonItemRepository.findAll().stream().map(lessonItemConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public LessonItemDTO findById(Long id) {
        return lessonItemConverter.toDTO(lessonItemRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("lesson item with this id isn't exist")));
    }
}
