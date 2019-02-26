package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dao.repository.UserRepository;
import com.project.mooc.moocproject.dto.CourseDTO;
import com.project.mooc.moocproject.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    @Autowired
    private UserRepository userRepository;

    public Course toEntity(CourseDTO courseDTO) {
        return Course.builder()
                .title(courseDTO.getTitle())
                .creator(userRepository.findById(courseDTO.getCreatorId()).
                        orElseThrow(() -> new RuntimeException("course mapper error")))
                .build();
    }

    public CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .title(course.getTitle())
                .creatorId(course.getCreator().getId())
                .build();
    }
}
