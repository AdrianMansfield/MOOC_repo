package com.exadel.MOOC.repository.view.staticInfo;

import com.exadel.MOOC.dto.staticInfo.ModuleForViewDto;

import java.util.Optional;

public interface IModuleForViewDto {

    Optional<ModuleForViewDto> findModuleForViewDtoByUserIdAndModuleId(Long userId, Long moduleId);
}
