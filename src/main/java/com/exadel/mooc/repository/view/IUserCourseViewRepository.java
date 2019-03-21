package com.exadel.mooc.repository.view;

import com.exadel.mooc.entity.view.UserCourse;

import java.util.List;

public interface IUserCourseViewRepository {
    List<UserCourse> findByUserIdAndCourseId(Long userId, Long courseId);

    List<UserCourse> findByUserId(Long userId);


}
