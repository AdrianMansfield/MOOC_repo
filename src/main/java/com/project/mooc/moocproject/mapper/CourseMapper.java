package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dao.repository.UserRepository;
import com.project.mooc.moocproject.dto.CourseDTO;
import com.project.mooc.moocproject.dto.UserViewDTO;
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
                .creator(userRepository.findByUserName(courseDTO.getCreator().getUserName())
                        .orElseThrow(() -> new RuntimeException("course mapper error")))
                .build();
    }

    public CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .title(course.getTitle())
                .creator(UserViewDTO.builder()
                        .firstName(course.getCreator().getFirstName())
                        .lastName(course.getCreator().getLastName())
                        .email(course.getCreator().getEmail())
                        .pictureLink(course.getCreator().getPictureLink())
                        .userName(course.getCreator().getUserName())
                        .build())
                .id(course.getId())
                .build();
    }
}
