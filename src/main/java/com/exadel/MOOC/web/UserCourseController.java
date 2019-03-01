package com.exadel.MOOC.web;

import com.exadel.MOOC.dto.view.UserCourseDTO;
import com.exadel.MOOC.service.IUserCourseService;
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


    @RequestMapping(value = "/specific-course",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserCourseDTO> findCourseByUserIdAndCourseId(@RequestParam("courseId") Long courseId,
                                                      @RequestParam("userId") Long userId) {
        return userCourseService.findByUserIdAndCourseId(userId, courseId);
    }

    @RequestMapping(value = "/all-courses",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserCourseDTO> findByUserId(@RequestParam("userId") Long userId){
        return userCourseService.findByUserId(userId);
    }
}
