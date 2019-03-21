package com.exadel.mooc.service.view;

import com.exadel.mooc.dto.view.UserLessonDTO;

import java.util.List;

public interface IUserLessonService {
    List<UserLessonDTO> findByUserIdAndLessonId(Long userId, Long lessonId);

    List<UserLessonDTO> findByUserId(Long userId);
}
