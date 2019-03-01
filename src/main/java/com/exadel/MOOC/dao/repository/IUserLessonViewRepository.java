package com.exadel.MOOC.dao.repository;

import com.exadel.MOOC.entity.view.UserLesson;

import java.util.List;

public interface IUserLessonViewRepository {
    List<UserLesson> findByUserIdAndLessonId(Long userId, Long lessonId);

    List<UserLesson> findByUserId(Long userId);
}
