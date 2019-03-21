package com.exadel.mooc.service;

import com.exadel.mooc.repository.ILessonRepository;
import com.exadel.mooc.dto.LessonDTO;
import com.exadel.mooc.mapper.LessonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService implements ILessonService {

    @Autowired
    private ILessonRepository lessonRepository;

    @Autowired
    private LessonMapper lessonMapper;

    @Override
    public void save(LessonDTO lessonDTO) {
        lessonRepository.save(lessonMapper.toEntity(lessonDTO));
    }

    @Override
    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public void update(LessonDTO lessonDTO) {
        lessonRepository.save(lessonMapper.toEntity(lessonDTO));
    }

    @Override
    public List<LessonDTO> findAll() {
        return lessonRepository.findAll().stream().map(lessonMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<LessonDTO> findByModuleId(Long moduleId) {
        return lessonRepository.findByModule_Id(moduleId).stream().map(lessonMapper::toDTO).collect(Collectors.toList());
    }
}
