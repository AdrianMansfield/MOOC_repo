package com.exadel.mooc.web;

import com.exadel.mooc.dto.view.UserCourseDTO;
import com.exadel.mooc.service.view.IUserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user-to-course")
public class UserCourseController {

    @Autowired
    private IUserCourseService userCourseService;


    @GetMapping(value = "/specific-course", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserCourseDTO> findCourseByUserIdAndCourseId(@RequestParam("courseId") Long courseId,
                                                      @RequestParam("userId") Long userId) {
        return userCourseService.findByUserIdAndCourseId(userId, courseId);
    }

    @GetMapping(value = "/all-courses", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserCourseDTO> findByUserId(@RequestParam("userId") Long userId) {
        return userCourseService.findByUserId(userId);
    }
}
