package com.exadel.mooc.service;

import com.exadel.mooc.dto.CourseDTO;

import java.util.List;


public interface ICourseService {
    void save(CourseDTO courseDTO);

    void deleteById(Long id);

    List<CourseDTO> findAll();

    void update(CourseDTO courseDTO);

    List<CourseDTO> findTop3ByOrderByIdDesc();

    CourseDTO findById(Long id) throws Exception;
}
