package com.exadel.mooc.converter.view;

import com.exadel.mooc.dto.view.UserLessonItemDTO;
import com.exadel.mooc.entity.view.UserLessonItem;
import org.springframework.stereotype.Component;

@Component
public class UserLessonItemMapper {

    public UserLessonItemDTO toDTO(UserLessonItem userLessonItem) {
        return UserLessonItemDTO.builder()
                .content(userLessonItem.getContent())
                .lessonId(userLessonItem.getLessonId())
                .lessonItemId(userLessonItem.getLessonId())
                .lessonItemName(userLessonItem.getName())
                .order(userLessonItem.getOrder())
                .status(userLessonItem.getStatus())
                .titleImg(userLessonItem.getTitleImg())
                .userId(userLessonItem.getUserId())
                .build();
    }
}
