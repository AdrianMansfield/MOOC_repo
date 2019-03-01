package com.exadel.MOOC.dao.repository;

import com.exadel.MOOC.entity.view.UserLessonItem;

import java.util.List;

public interface IUserLessonItemViewRepository {
    List<UserLessonItem> findByUserIdAndLessonItemId(Long userId, Long lessonItemId);

    List<UserLessonItem> findByUserId(Long userId);
}
