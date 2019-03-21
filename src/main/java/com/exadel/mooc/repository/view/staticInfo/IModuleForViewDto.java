package com.exadel.mooc.repository.view.staticInfo;

import com.exadel.mooc.dto.staticInfo.ModuleForViewDto;

import java.util.Optional;

public interface IModuleForViewDto {

    Optional<ModuleForViewDto> findModuleForViewDtoByUserIdAndModuleId(Long userId, Long moduleId);
}
