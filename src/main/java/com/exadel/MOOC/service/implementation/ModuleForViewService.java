package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.staticInfo.ILessonForViewDto;
import com.exadel.MOOC.dao.repository.staticInfo.ILessonItemForViewDto;
import com.exadel.MOOC.dao.repository.staticInfo.IModuleForViewDto;
import com.exadel.MOOC.dto.staticInfo.LessonForViewDto;
import com.exadel.MOOC.dto.staticInfo.LessonItemForViewDto;
import com.exadel.MOOC.dto.staticInfo.ModuleForViewDto;
import com.exadel.MOOC.service.IModuleForViewService;
import javassist.NotFoundException;
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
    public ModuleForViewDto getModuleInfo(Long userId, Long moduleId) throws NotFoundException {
        ModuleForViewDto module = moduleForViewDto.findModuleForViewDtoByUserIdAndModuleId(userId, moduleId).orElseThrow(
                () -> new NotFoundException("module for this moduleId and userId not found"));
        List<LessonForViewDto> lessons = lessonForViewDto.findLessonForViewDtoByUserIdAndModuleId(userId, moduleId);
        List<LessonForViewDto> filledLessons = lessons.stream().peek(lesson ->
        {
            Long lessonId = lesson.getLessonId();
            List<LessonItemForViewDto> lessonItems = lessonItemForViewDto.findLessonItemForViewDtoByUserIdAndLessonId(userId, lessonId);
            lesson.setLessonItemForViewDtos(lessonItems);
        }).collect(Collectors.toList());
        module.setLessonForViewDtos(filledLessons);
        return module;
    }
}
