package com.project.mooc.moocproject.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LessonItemDTO  implements Serializable {
    private String name;
    private String order;
    private String content;
    private String title_img_link;
    private LessonDTO lesson;
}
