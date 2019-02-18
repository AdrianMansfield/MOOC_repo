package com.project.mooc.moocproject.dao.service.lesson.implementation;

import com.project.mooc.moocproject.dao.repository.LessonRepository;
import com.project.mooc.moocproject.dao.service.lesson.LessonService;
import com.project.mooc.moocproject.dto.LessonDTO;
import com.project.mooc.moocproject.mapper.LessonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImplementation implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

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
}
