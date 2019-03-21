package com.exadel.mooc.dto.view;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserLessonDTO implements Serializable {
    private Long lessonId;
    private String title;
    private int order;
    private Long moduleId;
    private Long userId;
    private String status;
}
