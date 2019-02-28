package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.ILessonItemRepository;
import com.exadel.MOOC.service.ILessonItemService;
import com.exadel.MOOC.dto.LessonItemDTO;
import com.exadel.MOOC.mapper.LessonItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonItemService implements ILessonItemService {

    @Autowired
    private ILessonItemRepository lessonItemRepository;

    @Autowired
    private LessonItemMapper lessonItemMapper;

    @Override
    public void save(LessonItemDTO lessonItemDTO) {
        lessonItemRepository.save(lessonItemMapper.toEntity(lessonItemDTO));
    }

    @Override
    public void deleteByID(Long id) {
        lessonItemRepository.deleteById(id);
    }

    @Override
    public void update(LessonItemDTO lessonItemDTO) {
        lessonItemRepository.save(lessonItemMapper.toEntity(lessonItemDTO));
    }

    @Override
    public List<LessonItemDTO> findAll() {
        return lessonItemRepository.findAll().stream().map(lessonItemMapper::toDTO).collect(Collectors.toList());
    }
}
