package com.exadel.MOOC.dao.repository;

import com.exadel.MOOC.entity.view.UserCourse;

import java.util.List;

public interface IUserCourseViewRepository {
    List<UserCourse> findByUserIdAndCourseId(Long userId, Long courseId);
}
