package com.exadel.mooc.service;

import com.exadel.mooc.converter.CourseConverter;
import com.exadel.mooc.dto.CourseDTO;
import com.exadel.mooc.exception.EntityNotFoundException;
import com.exadel.mooc.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private CourseConverter courseConverter;

    @Override
    public void save(CourseDTO courseDTO) {
        courseRepository.save(courseConverter.toEntity(courseDTO));
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(courseConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public void update(CourseDTO courseDTO) {
        courseRepository.save(courseConverter.toEntity(courseDTO));
    }

    @Override
    public List<CourseDTO> findTop3ByOrderByIdDesc() {
        return courseRepository.findTop3ByOrderByIdDesc().stream().map(courseConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(Long id) {
        return courseConverter.toDTO(courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not find course with this is:" + id)));
    }
}
