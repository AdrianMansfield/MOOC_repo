package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.view.UserCourseDTO;

import java.util.List;

public interface IUserCourseService {
    List<UserCourseDTO> findByUserIdAndCourseId(Long userId, Long courseId);

    List<UserCourseDTO> findByUserId(Long userId);
}
