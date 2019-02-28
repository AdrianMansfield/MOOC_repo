package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.view.UserLessonDTO;

import java.util.List;

public interface IUserLessonService {
    List<UserLessonDTO> findByUserIdAndLessonId(Long userId, Long lessonId);
}
