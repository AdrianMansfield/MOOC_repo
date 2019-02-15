package com.project.mooc.moocproject.dao.service.course.implementation;

import com.project.mooc.moocproject.dao.repository.CourseRepository;
import com.project.mooc.moocproject.dao.service.course.CourseService;
import com.project.mooc.moocproject.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImplementation implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);
    }
}
