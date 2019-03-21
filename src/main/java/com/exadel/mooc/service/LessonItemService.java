package com.exadel.mooc.service;

import com.exadel.mooc.repository.ILessonItemRepository;
import com.exadel.mooc.dto.LessonItemDTO;
import com.exadel.mooc.mapper.LessonItemMapper;
import javassist.NotFoundException;
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

    @Override
    public LessonItemDTO findById(Long id) throws NotFoundException {
        return lessonItemMapper.toDTO(lessonItemRepository.findById(id).orElseThrow(() ->
                new NotFoundException("lesson item with this id isn't exist")));
    }
}
