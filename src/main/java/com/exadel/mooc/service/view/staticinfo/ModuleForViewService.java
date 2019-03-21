package com.exadel.mooc.service.view.staticinfo;

import com.exadel.mooc.dto.staticinfo.LessonForViewDTO;
import com.exadel.mooc.dto.staticinfo.LessonItemForViewDTO;
import com.exadel.mooc.dto.staticinfo.ModuleForViewDTO;
import com.exadel.mooc.exception.EntityNotFoundException;
import com.exadel.mooc.repository.view.staticinfo.ILessonForViewDto;
import com.exadel.mooc.repository.view.staticinfo.ILessonItemForViewDto;
import com.exadel.mooc.repository.view.staticinfo.IModuleForViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleForViewService implements IModuleForViewService {

    @Autowired
    private IModuleForViewDto moduleForViewDto;

    @Autowired
    private ILessonForViewDto lessonForViewDto;

    @Autowired
    private ILessonItemForViewDto lessonItemForViewDto;

    @Override
    public ModuleForViewDTO getModuleInfo(Long userId, Long moduleId) {
        ModuleForViewDTO module = moduleForViewDto.findModuleForViewDtoByUserIdAndModuleId(userId, moduleId).orElseThrow(
                () -> new EntityNotFoundException("module for this moduleId and userId not found"));
        List<LessonForViewDTO> lessons = lessonForViewDto.findLessonForViewDtoByUserIdAndModuleId(userId, moduleId);
        List<LessonForViewDTO> filledLessons = lessons.stream().peek(lesson ->
        {
            Long lessonId = lesson.getLessonId();
            List<LessonItemForViewDTO> lessonItems = lessonItemForViewDto.findLessonItemForViewDtoByUserIdAndLessonId(userId, lessonId);
            lesson.setLessonItemForViewDTOS(lessonItems);
        }).collect(Collectors.toList());
        module.setLessonForViewDTOS(filledLessons);
        return module;
    }
}
