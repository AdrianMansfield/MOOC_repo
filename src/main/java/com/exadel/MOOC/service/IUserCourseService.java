package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.view.UserCourseDTO;
import com.exadel.MOOC.entity.view.UserCourse;

import java.util.List;

public interface IUserCourseService {
    List<UserCourseDTO> findByUserIdAndCourseId(Long userId, Long courseId);
}
