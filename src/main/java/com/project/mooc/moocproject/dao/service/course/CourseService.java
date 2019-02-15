package com.project.mooc.moocproject.dao.service.course;

import com.project.mooc.moocproject.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    void save(Course course);
    void delete(Long id);
    List<Course> findAll();
    void update(Course course);
}
