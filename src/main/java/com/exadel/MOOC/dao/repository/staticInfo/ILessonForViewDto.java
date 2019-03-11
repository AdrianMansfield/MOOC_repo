package com.exadel.MOOC.dao.repository.staticInfo;

import com.exadel.MOOC.dto.staticInfo.LessonForViewDto;

import java.util.List;

public interface ILessonForViewDto {

    List<LessonForViewDto> findLessonForViewDtoByUserIdAndModuleId(Long userId, Long moduleId);
}
