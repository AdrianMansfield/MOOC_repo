package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dto.CourseDTO;
import com.project.mooc.moocproject.entity.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CourseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Course toEntity(CourseDTO courseDTO) {
        return Objects.isNull(courseDTO) ? null : modelMapper.map(courseDTO, Course.class);
    }

    public CourseDTO toDTO(Course course) {
        return Objects.isNull(course) ? null : modelMapper.map(course, CourseDTO.class);
    }
}
