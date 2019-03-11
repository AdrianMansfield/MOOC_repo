package com.exadel.MOOC.web;

import com.exadel.MOOC.dto.staticInfo.ModuleForViewDto;
import com.exadel.MOOC.service.IModuleForViewService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("module-info")
public class StaticInfoController {

    @Autowired
    private IModuleForViewService moduleForViewService;

    @RequestMapping(value = "/full-info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModuleForViewDto getFullInfoAboutModule(@RequestParam("userId") Long userId,
                                                   @RequestParam("moduleId") Long moduleId) throws NotFoundException {
        return moduleForViewService.getModuleInfo(userId, moduleId);
    }
}
