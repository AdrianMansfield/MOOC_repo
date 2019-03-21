package com.exadel.mooc.service;

import com.exadel.mooc.converter.LessonConverter;
import com.exadel.mooc.dto.LessonDTO;
import com.exadel.mooc.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService implements ILessonService {

    @Autowired
    private ILessonRepository lessonRepository;

    @Autowired
    private LessonConverter lessonConverter;

    @Override
    public void save(LessonDTO lessonDTO) {
        lessonRepository.save(lessonConverter.toEntity(lessonDTO));
    }

    @Override
    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public void update(LessonDTO lessonDTO) {
        lessonRepository.save(lessonConverter.toEntity(lessonDTO));
    }

    @Override
    public List<LessonDTO> findAll() {
        return lessonRepository.findAll().stream().map(lessonConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<LessonDTO> findByModuleId(Long moduleId) {
        return lessonRepository.findByModuleId(moduleId).stream().map(lessonConverter::toDTO).collect(Collectors.toList());
    }
}
