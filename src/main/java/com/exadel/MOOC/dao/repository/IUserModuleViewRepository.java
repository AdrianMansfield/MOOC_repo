package com.exadel.MOOC.dao.repository;

import com.exadel.MOOC.dto.view.UserModuleDTO;
import com.exadel.MOOC.entity.view.UserModule;

import java.util.List;

public interface IUserModuleViewRepository {
    List<UserModule> findByUserIdAndModuleId(Long userId, Long moduleId);
}
