package com.exadel.MOOC.web;

import com.exadel.MOOC.dao.service.course.CourseService;
import com.exadel.MOOC.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<CourseDTO> findAll() {
        return courseService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<CourseDTO> coursesDTO) {
        coursesDTO.forEach(courseService::save);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        courseService.deleteById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<CourseDTO> courseDTOS) {
        courseDTOS.forEach(courseService::update);
    }

    @RequestMapping(value = "/three-latest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<CourseDTO> getLatestRow() {
        return courseService.findTop3ByOrderByIdDesc();
    }

}
