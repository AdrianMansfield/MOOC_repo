package com.exadel.mooc.repository.view.staticInfo;

import com.exadel.mooc.dto.staticInfo.LessonForViewDto;

import java.util.List;

public interface ILessonForViewDto {

    List<LessonForViewDto> findLessonForViewDtoByUserIdAndModuleId(Long userId, Long moduleId);
}
