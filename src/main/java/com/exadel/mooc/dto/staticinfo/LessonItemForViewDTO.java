package com.exadel.mooc.dto.staticinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonItemForViewDTO {

    private Long lessonItemId;
    private String name;
    private int order;
    private Long lessonId;
    private Long userId;
    private String status;
}
