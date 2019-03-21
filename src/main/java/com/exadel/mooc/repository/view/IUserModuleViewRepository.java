package com.exadel.mooc.repository.view;

import com.exadel.mooc.entity.view.UserModule;

import java.util.List;

public interface IUserModuleViewRepository {
    List<UserModule> findByUserIdAndModuleId(Long userId, Long moduleId);

    List<UserModule> findByUserId(Long userId);

    List<UserModule> findByUserIdAndCourseId(Long userId, Long courseId);
}
