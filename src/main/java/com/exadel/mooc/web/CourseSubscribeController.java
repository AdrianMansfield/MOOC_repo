package com.exadel.mooc.web;

import com.exadel.mooc.security.CustomUser;
import com.exadel.mooc.service.ICourseSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/course-actions")
public class CourseSubscribeController {

    @Autowired
    private ICourseSubscriptionService courseSubscriptionService;

    private Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return customUser.getUserId();
    }


    @PostMapping(value = "/subscribe")
    boolean subscribeToCourse(@RequestBody Long courseId) {
        return courseSubscriptionService.subscribe(getUserId(), courseId);
    }
}
