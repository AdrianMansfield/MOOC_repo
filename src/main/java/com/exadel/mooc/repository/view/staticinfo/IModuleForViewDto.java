package com.exadel.mooc.repository.view.staticinfo;

import com.exadel.mooc.dto.staticinfo.ModuleForViewDTO;

import java.util.Optional;

public interface IModuleForViewDto {

    Optional<ModuleForViewDTO> findModuleForViewDtoByUserIdAndModuleId(Long userId, Long moduleId);
}
