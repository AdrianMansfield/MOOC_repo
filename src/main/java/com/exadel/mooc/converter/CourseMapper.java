package com.exadel.mooc.converter;

import com.exadel.mooc.repository.IUserRepository;
import com.exadel.mooc.dto.CourseDTO;
import com.exadel.mooc.dto.UserForViewDTO;
import com.exadel.mooc.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    @Autowired
    private IUserRepository userRepository;

    public Course toEntity(CourseDTO courseDTO) {
        return Course.builder()
                .title(courseDTO.getTitle())
                .creator(userRepository.findByUserName(courseDTO.getCreator().getUserName())
                        .orElseThrow(() -> new RuntimeException("course converter error")))
                .build();
    }

    public CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .title(course.getTitle())
                .creator(UserForViewDTO.builder()
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
