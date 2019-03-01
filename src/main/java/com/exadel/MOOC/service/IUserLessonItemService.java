package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.view.UserLessonItemDTO;

import java.util.List;

public interface IUserLessonItemService {
    List<UserLessonItemDTO> findByUserIdAndLessonItemId(Long userId, Long lessonItemId);

     List<UserLessonItemDTO> findByUserId(Long userId);
}
