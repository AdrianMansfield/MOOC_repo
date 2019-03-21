package com.exadel.mooc.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LessonItemDTO implements Serializable {
    private String name;
    private int order;
    private String content;
    private String title_img_link;
    private Long lessonId;
}
