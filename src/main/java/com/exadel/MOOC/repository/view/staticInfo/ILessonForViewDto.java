package com.exadel.MOOC.repository.view.staticInfo;

import com.exadel.MOOC.dto.staticInfo.LessonForViewDto;

import java.util.List;

public interface ILessonForViewDto {

    List<LessonForViewDto> findLessonForViewDtoByUserIdAndModuleId(Long userId, Long moduleId);
}
