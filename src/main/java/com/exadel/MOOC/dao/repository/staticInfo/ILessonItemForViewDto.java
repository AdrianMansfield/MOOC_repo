package com.exadel.MOOC.dao.repository.staticInfo;

import com.exadel.MOOC.dto.staticInfo.LessonItemForViewDto;

import java.util.List;


public interface ILessonItemForViewDto {

    List<LessonItemForViewDto> findLessonItemForViewDtoByUserIdAndLessonId(Long userId, Long lessonId);
}
