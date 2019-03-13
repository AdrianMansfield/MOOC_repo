package com.exadel.MOOC.web;

import com.exadel.MOOC.security.CustomUser;
import com.exadel.MOOC.service.ICourseSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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


    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    boolean subscribeToCourse(@RequestBody Long courseId) {
        return courseSubscriptionService.subscribe(getUserId(), courseId);
    }

//    @RequestMapping(value = "/unsubscribe", method = RequestMethod.POST)
//    boolean unsubscribeToCourse (@RequestBody Long courseId){
//        return courseSubscriptionService.unsubscribe(getUserId(), courseId);
//    }

//    @RequestMapping(value = "/isSubscribed", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    boolean isSubscribed(@RequestBody Long courseId) {
//        return courseSubscriptionService.isSubscribed(getUserId(), courseId);
//    }


}
