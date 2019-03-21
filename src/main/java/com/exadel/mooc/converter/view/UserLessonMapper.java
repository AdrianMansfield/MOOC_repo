package com.exadel.mooc.converter.view;

import com.exadel.mooc.dto.view.UserLessonDTO;
import com.exadel.mooc.entity.view.UserLesson;
import org.springframework.stereotype.Component;

@Component
public class UserLessonMapper {

    public UserLessonDTO toDTO(UserLesson userLesson) {
        return UserLessonDTO.builder()
                .lessonId(userLesson.getLessonId())
                .moduleId(userLesson.getModuleId())
                .order(userLesson.getOrder())
                .status(userLesson.getStatus())
                .title(userLesson.getTitle())
                .userId(userLesson.getUserId())
                .build();
    }
}
