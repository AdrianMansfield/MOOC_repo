package com.exadel.mooc.web;

import com.exadel.mooc.dto.view.UserModuleDTO;
import com.exadel.mooc.security.CustomUser;
import com.exadel.mooc.service.view.IUserModuleService;
import com.exadel.mooc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "user-to-module")
public class UserModuleController {

    @Autowired
    private IUserModuleService userModuleService;

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/specific-module", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserModuleDTO> findModuleByUserIdAndModuleId(@RequestParam("moduleId") Long moduleId,
                                                      @RequestParam("userId") Long userId) {
        return userModuleService.findByUserIdAndModuleId(userId, moduleId);
    }

    @RequestMapping(value = "/all-modules", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserModuleDTO> findByUserId(@RequestParam("userId") Long userId) {
        return userModuleService.findByUserId(userId);
    }

    @RequestMapping(value = "/modules-by-course", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserModuleDTO> findByUserIdAndCourseId(@RequestParam("courseId") Long courseId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return userModuleService.findByUserIdAndCourseId(customUser.getUserId(), courseId);
    }
}
