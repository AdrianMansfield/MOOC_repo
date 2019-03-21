package com.exadel.mooc.repository.view;

import com.exadel.mooc.entity.view.UserLessonItem;

import java.util.List;

public interface IUserLessonItemViewRepository {
    List<UserLessonItem> findByUserIdAndLessonItemId(Long userId, Long lessonItemId);

    List<UserLessonItem> findByUserId(Long userId);
}
