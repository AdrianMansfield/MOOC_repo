package com.exadel.MOOC.dto.staticInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonItemForViewDto {

    private Long lessonItemId;
    private String name;
    private int order;
    private String content;
    private String titleImg;
    private Long lessonId;
    private Long userId;
    private String status;
}
