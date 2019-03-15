package com.exadel.MOOC.mapper.view;

import com.exadel.MOOC.repository.view.UserCourseViewRepository;
import com.exadel.MOOC.dto.view.UserCourseDTO;
import com.exadel.MOOC.entity.view.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCourseMapper {

    @Autowired
    private UserCourseViewRepository userCourseViewRepository;

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
