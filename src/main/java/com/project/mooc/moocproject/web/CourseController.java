package com.project.mooc.moocproject.web;

import com.project.mooc.moocproject.dao.service.course.CourseService;
import com.project.mooc.moocproject.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Course> findAll() {
        return courseService.findAll();
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<Course> courses) {
        courses.forEach(courseService::save);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id){
        courseService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    void update(@RequestBody final List<Course> courses){
        courses.forEach(courseService::update);
    }
}
