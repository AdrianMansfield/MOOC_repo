package com.exadel.MOOC.mapper.view;

import com.exadel.MOOC.dao.repository.implementation.UserLessonViewRepository;
import com.exadel.MOOC.dto.view.UserLessonDTO;
import com.exadel.MOOC.entity.view.UserLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLessonMapper {

    @Autowired
    private UserLessonViewRepository userLessonViewRepository;

    public UserLessonDTO toDTO(UserLesson userLesson) {
        return UserLessonDTO.builder()
                .lessonId(userLesson.getId())
                .moduleId(userLesson.getModuleId())
                .order(userLesson.getOrder())
                .status(userLesson.getStatus())
                .title(userLesson.getTitle())
                .userId(userLesson.getUserId())
                .build();
    }
}