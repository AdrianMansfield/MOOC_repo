package com.exadel.mooc.repository.view.staticInfo;

import com.exadel.mooc.dto.staticInfo.LessonItemForViewDto;

import java.util.List;


public interface ILessonItemForViewDto {

    List<LessonItemForViewDto> findLessonItemForViewDtoByUserIdAndLessonId(Long userId, Long lessonId);
}
