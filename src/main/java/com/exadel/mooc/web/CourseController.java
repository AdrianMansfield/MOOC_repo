package com.exadel.mooc.web;

import com.exadel.mooc.dto.CourseDTO;
import com.exadel.mooc.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/course")
@Slf4j
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<CourseDTO> findAll() {
        return courseService.findAll();
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<CourseDTO> coursesDTO) {
        coursesDTO.forEach(courseService::save);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        courseService.deleteById(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<CourseDTO> courseDTOS) {
        courseDTOS.forEach(courseService::update);
    }

    @GetMapping(value = "/three-latest", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<CourseDTO> getLatestRow() {
        log.info("Example log from controller {}", 2 * 3);
        return courseService.findTop3ByOrderByIdDesc();
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    CourseDTO findById(@RequestParam("courseId") Long id) {
        return courseService.findById(id);
    }

}
