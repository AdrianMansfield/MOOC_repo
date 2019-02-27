package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.CourseRepository;
import com.exadel.MOOC.service.ICourseService;
import com.exadel.MOOC.dto.CourseDTO;
import com.exadel.MOOC.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void save(CourseDTO courseDTO) {
        courseRepository.save(courseMapper.toEntity(courseDTO));
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(courseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void update(CourseDTO courseDTO) {
        courseRepository.save(courseMapper.toEntity(courseDTO));
    }

    @Override
    public List<CourseDTO> findTop3ByOrderByIdDesc() {
        return courseRepository.findTop3ByOrderByIdDesc().stream().map(courseMapper::toDTO).collect(Collectors.toList());
    }
}
