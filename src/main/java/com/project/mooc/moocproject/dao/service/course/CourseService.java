package com.project.mooc.moocproject.dao.service.course;

import com.project.mooc.moocproject.dto.CourseDTO;
import com.project.mooc.moocproject.entity.Course;

import java.util.List;


public interface CourseService {
    void save(CourseDTO courseDTO);

    void deleteById(Long id);

    List<CourseDTO> findAll();

    void update(CourseDTO courseDTO);
}
