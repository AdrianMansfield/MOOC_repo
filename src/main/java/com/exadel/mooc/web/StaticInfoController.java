package com.exadel.mooc.web;

import com.exadel.mooc.dto.staticinfo.CourseForViewDTO;
import com.exadel.mooc.dto.staticinfo.ModuleForViewDTO;
import com.exadel.mooc.security.CustomUser;
import com.exadel.mooc.service.view.staticinfo.ICourseForViewService;
import com.exadel.mooc.service.view.staticinfo.IModuleForViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/static-info")
public class StaticInfoController {

    @Autowired
    private IModuleForViewService moduleForViewService;

    @Autowired
    private ICourseForViewService courseForViewService;

    private Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return customUser.getUserId();
    }

    @GetMapping(value = "/module-info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModuleForViewDTO getFullInfoAboutModule(@RequestParam("moduleId") Long moduleId) {
        return moduleForViewService.getModuleInfo(getUserId(), moduleId);
    }

    @GetMapping(value = "/course-info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CourseForViewDTO getFullInfoAboutCourse(@RequestParam("courseId") Long courseId) {
        return courseForViewService.getCourseInfo(getUserId(), courseId);
    }
}
