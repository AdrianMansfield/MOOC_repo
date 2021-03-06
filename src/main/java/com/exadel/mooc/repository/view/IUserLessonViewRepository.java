package com.exadel.mooc.repository.view;

import com.exadel.mooc.entity.view.UserLesson;

import java.util.List;

public interface IUserLessonViewRepository {
    List<UserLesson> findByUserIdAndLessonId(Long userId, Long lessonId);

    List<UserLesson> findByUserId(Long userId);
}
