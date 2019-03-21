package com.exadel.mooc.dto.staticinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonForViewDTO {
    private Long lessonId;
    private String title;
    private int order;
    private Long moduleId;
    private Long userId;
    private String status;
    private List<LessonItemForViewDTO> lessonItemForViewDTOS;

}
