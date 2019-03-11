package com.exadel.MOOC.web;

import com.exadel.MOOC.dto.LessonItemDTO;
import com.exadel.MOOC.service.ILessonItemService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lesson-item")
public class LessonItemController {

    @Autowired
    private ILessonItemService lessonItemService;

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<LessonItemDTO> lessonItemDTOS) {
        lessonItemDTOS.forEach(lessonItemService::update);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        lessonItemService.deleteByID(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<LessonItemDTO> findAll() {
        return lessonItemService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<LessonItemDTO> lessonItemDTOS) {
        lessonItemDTOS.forEach(lessonItemService::save);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    LessonItemDTO findById(@PathVariable Long id) throws NotFoundException {
        return lessonItemService.findById(id);
    }
}
