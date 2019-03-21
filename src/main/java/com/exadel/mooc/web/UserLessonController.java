package com.exadel.mooc.web;

import com.exadel.mooc.dto.view.UserLessonDTO;
import com.exadel.mooc.service.view.IUserLessonService;
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


    @GetMapping(value = "/specific-lesson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserLessonDTO> findLessonByUserIdAndLessonId(@RequestParam("lessonId") Long lessonId,
                                                      @RequestParam("userId") Long userId) {
        return userLessonService.findByUserIdAndLessonId(userId, lessonId);
    }

    @GetMapping(value = "/all-lessons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserLessonDTO> findByUserId(@RequestParam("userId") Long userId) {
        return userLessonService.findByUserId(userId);
    }
}
