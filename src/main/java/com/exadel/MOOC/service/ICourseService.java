package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.CourseDTO;

import java.util.List;


public interface ICourseService {
    void save(CourseDTO courseDTO);

    void deleteById(Long id);

    List<CourseDTO> findAll();

    void update(CourseDTO courseDTO);

    List<CourseDTO> findTop3ByOrderByIdDesc();
}
