package com.exadel.mooc.service.view.staticInfo;

import com.exadel.mooc.dto.staticInfo.ModuleForViewDto;
import javassist.NotFoundException;

public interface IModuleForViewService {
    ModuleForViewDto getModuleInfo(Long userId, Long moduleId) throws NotFoundException;
}
