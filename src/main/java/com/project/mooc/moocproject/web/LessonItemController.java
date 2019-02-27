package com.project.mooc.moocproject.web;

import com.project.mooc.moocproject.dao.service.lessonItem.LessonItemService;
import com.project.mooc.moocproject.dto.LessonItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson-item")
public class LessonItemController {

    @Autowired
    private LessonItemService lessonItemService;

    @RequestMapping(value = "/update",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<LessonItemDTO> lessonItemDTOS) {
        lessonItemDTOS.forEach(lessonItemService::update);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        lessonItemService.deleteByID(id);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<LessonItemDTO> findAll() {
        return lessonItemService.findAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<LessonItemDTO> lessonItemDTOS) {
        lessonItemDTOS.forEach(lessonItemService::save);
    }
}
