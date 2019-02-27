package com.project.mooc.moocproject.web;

import com.project.mooc.moocproject.dao.service.course.CourseService;
import com.project.mooc.moocproject.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<CourseDTO> findAll() {
        return courseService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<CourseDTO> coursesDTO) {
        coursesDTO.forEach(courseService::save);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        courseService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<CourseDTO> courseDTOS) {
        courseDTOS.forEach(courseService::update);
    }

    @RequestMapping(value = "/get-latest-posts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<CourseDTO> getLatestRow(){
        return courseService.findTop3ByOrderByIdDesc();
    }

}
