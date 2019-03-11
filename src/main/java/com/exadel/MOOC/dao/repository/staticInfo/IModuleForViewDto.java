package com.exadel.MOOC.dao.repository.staticInfo;

import com.exadel.MOOC.dto.staticInfo.ModuleForViewDto;

import java.util.Optional;

public interface IModuleForViewDto {

    Optional<ModuleForViewDto> findModuleForViewDtoByUserIdAndModuleId(Long userId, Long moduleId);
}
