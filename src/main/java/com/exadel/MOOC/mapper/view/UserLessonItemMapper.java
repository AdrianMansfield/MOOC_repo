package com.exadel.MOOC.mapper.view;

import com.exadel.MOOC.dao.repository.implementation.UserLessonItemViewRepository;
import com.exadel.MOOC.dto.view.UserLessonItemDTO;
import com.exadel.MOOC.entity.view.UserLessonItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLessonItemMapper {

    @Autowired
    private UserLessonItemViewRepository userLessonItemViewRepository;

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
