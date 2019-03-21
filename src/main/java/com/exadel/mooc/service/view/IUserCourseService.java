package com.exadel.mooc.service.view;

import com.exadel.mooc.dto.view.UserCourseDTO;

import java.util.List;

public interface IUserCourseService {
    List<UserCourseDTO> findByUserIdAndCourseId(Long userId, Long courseId);

    List<UserCourseDTO> findByUserId(Long userId);
}
