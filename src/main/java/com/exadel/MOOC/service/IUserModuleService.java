package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.view.UserModuleDTO;

import java.util.List;

public interface IUserModuleService {
    List<UserModuleDTO> findByUserIdAndModuleId(Long userId, Long moduleId);
}
