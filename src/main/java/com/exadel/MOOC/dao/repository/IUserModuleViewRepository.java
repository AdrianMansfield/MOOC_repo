package com.exadel.MOOC.dao.repository;

import com.exadel.MOOC.entity.view.UserModule;

import java.util.List;

public interface IUserModuleViewRepository {
    List<UserModule> findByUserIdAndModuleId(Long userId, Long moduleId);

    List<UserModule> findByUserId(Long userId);
}
