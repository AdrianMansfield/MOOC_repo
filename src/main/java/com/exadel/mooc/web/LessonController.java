package com.exadel.mooc.web;

import com.exadel.mooc.dto.LessonDTO;
import com.exadel.mooc.service.ILessonService;
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

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<LessonDTO> findAll() {
        return lessonService.findAll();
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<LessonDTO> lessonDTOS) {
        lessonDTOS.forEach(lessonService::save);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        lessonService.deleteById(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<LessonDTO> courseDTOS) {
        courseDTOS.forEach(lessonService::update);
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<LessonDTO> findByModuleId(@RequestParam("moduleId") Long moduleId) {
        return lessonService.findByModuleId(moduleId);
    }
}
