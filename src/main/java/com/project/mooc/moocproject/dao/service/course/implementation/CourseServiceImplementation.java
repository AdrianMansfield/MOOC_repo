package com.project.mooc.moocproject.dao.service.course.implementation;

import com.project.mooc.moocproject.dao.repository.CourseRepository;
import com.project.mooc.moocproject.dao.service.course.CourseService;
import com.project.mooc.moocproject.dto.CourseDTO;
import com.project.mooc.moocproject.entity.Course;
import com.project.mooc.moocproject.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImplementation implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper mapper;

    @Override
    public void save(CourseDTO courseDTO) {
        courseRepository.save(mapper.toEntity(courseDTO));
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void update(CourseDTO courseDTO) {
        courseRepository.save(mapper.toEntity(courseDTO));
    }

    @Override
    public List<CourseDTO> findTop3ByOrderByIdDesc() {
        return courseRepository.findTop3ByOrderByIdDesc().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
