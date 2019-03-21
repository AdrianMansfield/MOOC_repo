package com.exadel.mooc.dto.staticInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonForViewDto {
    private Long lessonId;
    private String title;
    private int order;
    private Long moduleId;
    private Long userId;
    private String status;
    private List<LessonItemForViewDto> lessonItemForViewDtos;

}
