package com.exadel.mooc.mapper.view;

import com.exadel.mooc.dto.view.UserCourseDTO;
import com.exadel.mooc.entity.view.UserCourse;
import org.springframework.stereotype.Component;

@Component
public class UserCourseMapper {

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
