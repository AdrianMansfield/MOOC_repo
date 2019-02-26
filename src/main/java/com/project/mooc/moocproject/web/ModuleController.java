package com.project.mooc.moocproject.web;

import com.project.mooc.moocproject.dao.service.module.ModuleService;
import com.project.mooc.moocproject.dto.ModuleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<ModuleDTO> moduleDTOS) {
        moduleDTOS.forEach(moduleService::save);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ModuleDTO> findAll() {
        return moduleService.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        moduleService.deleteByID(id);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<ModuleDTO> moduleDTOS) {
        moduleDTOS.forEach(moduleService::update);
    }

    @RequestMapping(value = "/get-modules-by-course/{courseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ModuleDTO> findByCourseId(@PathVariable Long courseId) {
        return moduleService.findByCourseId(courseId);
    }
}
