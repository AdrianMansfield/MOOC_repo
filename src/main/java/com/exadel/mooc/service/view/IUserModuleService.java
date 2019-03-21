package com.exadel.mooc.service.view;

import com.exadel.mooc.dto.view.UserModuleDTO;

import java.util.List;

public interface IUserModuleService {
    List<UserModuleDTO> findByUserIdAndModuleId(Long userId, Long moduleId);

    List<UserModuleDTO> findByUserId(Long userId);

    List<UserModuleDTO> findByUserIdAndCourseId(Long userId, Long courseId);
}
