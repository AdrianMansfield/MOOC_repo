package com.exadel.mooc.web;

import com.exadel.mooc.dto.ModuleDTO;
import com.exadel.mooc.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private IModuleService moduleService;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<ModuleDTO> moduleDTOS) {
        moduleDTOS.forEach(moduleService::save);
    }

    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<ModuleDTO> findAll() {
        return moduleService.findAll();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        moduleService.deleteByID(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<ModuleDTO> moduleDTOS) {
        moduleDTOS.forEach(moduleService::update);
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<ModuleDTO> findByCourseId(@RequestParam("courseId") Long courseId) {
        return moduleService.findByCourseId(courseId);
    }
}
