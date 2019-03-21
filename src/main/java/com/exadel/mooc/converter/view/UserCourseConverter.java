package com.exadel.mooc.converter.view;

import com.exadel.mooc.dto.view.UserCourseDTO;
import com.exadel.mooc.entity.view.UserCourse;
import org.springframework.stereotype.Component;

@Component
public class UserCourseConverter {

    public UserCourseDTO toDTO(UserCourse userCourse) {
        return UserCourseDTO.builder()
                .courseId(userCourse.getId())
                .creatorId(userCourse.getCreatorId())
                .status(userCourse.getStatus())
                .title(userCourse.getTitle())
                .userId(userCourse.getUserId())
                .build();
    }
}
