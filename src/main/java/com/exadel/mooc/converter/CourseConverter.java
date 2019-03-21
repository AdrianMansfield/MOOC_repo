package com.exadel.mooc.converter;

import com.exadel.mooc.dto.CourseDTO;
import com.exadel.mooc.dto.UserForViewDTO;
import com.exadel.mooc.entity.Course;
import com.exadel.mooc.exception.EntityNotFoundException;
import com.exadel.mooc.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseConverter {

    @Autowired
    private IUserRepository userRepository;

    public Course toEntity(CourseDTO courseDTO) {
        log.info("Convert CourseDTO {} to entity", courseDTO);
        return Course.builder()
                .title(courseDTO.getTitle())
                .creator(userRepository.findByUserName(courseDTO.getCreator().getUserName())
                        .orElseThrow(() -> new EntityNotFoundException("Not found user with userName:" + courseDTO.getCreator().getUserName())))
                .build();
    }

    public CourseDTO toDTO(Course course) {
        log.info("Convert Course {} to DTO", course);
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
