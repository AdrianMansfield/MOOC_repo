package com.exadel.mooc.web;

import com.exadel.mooc.dto.LessonItemDTO;
import com.exadel.mooc.security.CustomUser;
import com.exadel.mooc.service.ILessonItemService;
import com.exadel.mooc.service.linkagetable.IUserToCourseHierarchyObjectAggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lesson-item")
public class LessonItemController {

    @Autowired
    private ILessonItemService lessonItemService;

    @Autowired
    private IUserToCourseHierarchyObjectAggregationService userToCourseHierarchyObjectAggregationService;

    private Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return customUser.getUserId();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<LessonItemDTO> lessonItemDTOS) {
        lessonItemDTOS.forEach(lessonItemService::update);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        lessonItemService.deleteByID(id);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<LessonItemDTO> findAll() {
        return lessonItemService.findAll();
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<LessonItemDTO> lessonItemDTOS) {
        lessonItemDTOS.forEach(lessonItemService::save);
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    LessonItemDTO findById(@PathVariable Long id){
        return lessonItemService.findById(id);
    }
}
