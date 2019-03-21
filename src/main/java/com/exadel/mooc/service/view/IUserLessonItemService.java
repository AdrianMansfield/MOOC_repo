package com.exadel.mooc.service.view;

import com.exadel.mooc.dto.view.UserLessonItemDTO;

import java.util.List;

public interface IUserLessonItemService {
    List<UserLessonItemDTO> findByUserIdAndLessonItemId(Long userId, Long lessonItemId);

     List<UserLessonItemDTO> findByUserId(Long userId);
}
