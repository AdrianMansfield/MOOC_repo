package com.exadel.mooc.service.view.staticinfo;

import com.exadel.mooc.dto.staticinfo.ModuleForViewDTO;

public interface IModuleForViewService {
    ModuleForViewDTO getModuleInfo(Long userId, Long moduleId);
}
