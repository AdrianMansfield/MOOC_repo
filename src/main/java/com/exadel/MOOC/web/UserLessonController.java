package com.exadel.MOOC.web;

import com.exadel.MOOC.dto.view.UserLessonDTO;
import com.exadel.MOOC.service.view.IUserLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user-to-lesson")
public class UserLessonController {

    @Autowired
    private IUserLessonService userLessonService;


    @RequestMapping(value = "/specific-lesson",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserLessonDTO> findLessonByUserIdAndLessonId(@RequestParam("lessonId") Long lessonId,
                                                      @RequestParam("userId") Long userId) {
        return userLessonService.findByUserIdAndLessonId(userId, lessonId);
    }

    @RequestMapping(value = "/all-lessons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserLessonDTO> findByUserId(@RequestParam("userId") Long userId){
        return userLessonService.findByUserId(userId);
    }
}
