package com.exadel.mooc.repository.view.staticinfo;

import com.exadel.mooc.dto.staticinfo.LessonItemForViewDTO;

import java.util.List;


public interface ILessonItemForViewDto {

    List<LessonItemForViewDTO> findLessonItemForViewDtoByUserIdAndLessonId(Long userId, Long lessonId);
}
