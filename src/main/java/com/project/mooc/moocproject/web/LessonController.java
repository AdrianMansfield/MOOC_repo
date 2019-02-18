package com.project.mooc.moocproject.web;

import com.project.mooc.moocproject.dao.service.lesson.LessonService;
import com.project.mooc.moocproject.dto.LessonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<LessonDTO> findAll() {
        return lessonService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<LessonDTO> lessonDTOS) {
        lessonDTOS.forEach(lessonService::save);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        lessonService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<LessonDTO> courseDTOS) {
        courseDTOS.forEach(lessonService::update);
    }
}
