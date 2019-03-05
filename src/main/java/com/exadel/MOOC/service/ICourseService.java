package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.CourseDTO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface ICourseService {
    void save(CourseDTO courseDTO);

    void deleteById(Long id);

    List<CourseDTO> findAll();

    void update(CourseDTO courseDTO);

    List<CourseDTO> findTop3ByOrderByIdDesc();

    CourseDTO findById(Long id) throws Exception;
}
