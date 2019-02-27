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

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<ModuleDTO> moduleDTOS) {
        moduleDTOS.forEach(moduleService::save);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<ModuleDTO> findAll() {
        return moduleService.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        moduleService.deleteByID(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<ModuleDTO> moduleDTOS) {
        moduleDTOS.forEach(moduleService::update);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<ModuleDTO> findByCourseId(@RequestParam("courseId") Long courseId) {
        return moduleService.findByCourseId(courseId);
    }
}
