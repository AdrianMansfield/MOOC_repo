package com.exadel.MOOC.repository.view.staticInfo;

import com.exadel.MOOC.dto.staticInfo.LessonItemForViewDto;

import java.util.List;


public interface ILessonItemForViewDto {

    List<LessonItemForViewDto> findLessonItemForViewDtoByUserIdAndLessonId(Long userId, Long lessonId);
}
