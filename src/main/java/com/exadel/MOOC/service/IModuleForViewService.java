package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.staticInfo.ModuleForViewDto;
import javassist.NotFoundException;

public interface IModuleForViewService {
    ModuleForViewDto getModuleInfo(Long userId, Long moduleId) throws NotFoundException;
}
