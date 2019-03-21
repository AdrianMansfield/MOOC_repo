package com.exadel.mooc.web;

import com.exadel.mooc.service.ILessonService;
import com.exadel.mooc.dto.LessonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private ILessonService lessonService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<LessonDTO> findAll() {
        return lessonService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<LessonDTO> lessonDTOS) {
        lessonDTOS.forEach(lessonService::save);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        lessonService.deleteById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<LessonDTO> courseDTOS) {
        courseDTOS.forEach(lessonService::update);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<LessonDTO> findByModuleId(@RequestParam("moduleId") Long moduleId) {
        return lessonService.findByModuleId(moduleId);
    }
}
