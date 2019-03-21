package com.exadel.mooc.web;

import com.exadel.mooc.dto.staticInfo.CourseForViewDto;
import com.exadel.mooc.dto.staticInfo.ModuleForViewDto;
import com.exadel.mooc.security.CustomUser;
import com.exadel.mooc.service.view.staticInfo.ICourseForViewService;
import com.exadel.mooc.service.view.staticInfo.IModuleForViewService;
import javassist.NotFoundException;
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

    private Long getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return customUser.getUserId();
    }

    @RequestMapping(value = "/module-info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModuleForViewDto getFullInfoAboutModule(@RequestParam("moduleId") Long moduleId) throws NotFoundException {
        return moduleForViewService.getModuleInfo(getUserId(), moduleId);
    }

    @RequestMapping(value = "/course-info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CourseForViewDto getFullInfoAboutCourse(@RequestParam("courseId") Long courseId) throws Exception {
        return courseForViewService.getCourseInfo(getUserId(),courseId);
    }
}
