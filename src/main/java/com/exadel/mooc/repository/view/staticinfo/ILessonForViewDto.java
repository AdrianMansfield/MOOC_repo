package com.exadel.mooc.repository.view.staticinfo;

import com.exadel.mooc.dto.staticinfo.LessonForViewDTO;

import java.util.List;

public interface ILessonForViewDto {

    List<LessonForViewDTO> findLessonForViewDtoByUserIdAndModuleId(Long userId, Long moduleId);
}
