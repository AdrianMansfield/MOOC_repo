package com.project.mooc.moocproject.dao.service.lessonItem.implementation;

import com.project.mooc.moocproject.dao.repository.LessonItemRepository;
import com.project.mooc.moocproject.dao.service.lessonItem.LessonItemService;
import com.project.mooc.moocproject.dto.LessonItemDTO;
import com.project.mooc.moocproject.mapper.LessonItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonItemServiceImplementation implements LessonItemService {

    @Autowired
    private LessonItemRepository lessonItemRepository;

    @Autowired
    private LessonItemMapper mapper;

    @Override
    public void save(LessonItemDTO lessonItemDTO) {
        lessonItemRepository.save(mapper.toEntity(lessonItemDTO));
    }

    @Override
    public void deleteByID(Long id) {
        lessonItemRepository.deleteById(id);
    }

    @Override
    public void update(LessonItemDTO lessonItemDTO) {
        lessonItemRepository.save(mapper.toEntity(lessonItemDTO));
    }

    @Override
    public List<LessonItemDTO> findAll() {
        return lessonItemRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
