package com.exadel.mooc.web;

import com.exadel.mooc.dto.view.UserModuleDTO;
import com.exadel.mooc.security.CustomUser;
import com.exadel.mooc.service.IUserService;
import com.exadel.mooc.service.view.IUserModuleService;
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


    @GetMapping(value = "/specific-module", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserModuleDTO> findModuleByUserIdAndModuleId(@RequestParam("moduleId") Long moduleId,
                                                      @RequestParam("userId") Long userId) {
        return userModuleService.findByUserIdAndModuleId(userId, moduleId);
    }

    @GetMapping(value = "/all-modules", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserModuleDTO> findByUserId(@RequestParam("userId") Long userId) {
        return userModuleService.findByUserId(userId);
    }

    @GetMapping(value = "/modules-by-course", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserModuleDTO> findByUserIdAndCourseId(@RequestParam("courseId") Long courseId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return userModuleService.findByUserIdAndCourseId(customUser.getUserId(), courseId);
    }
}
