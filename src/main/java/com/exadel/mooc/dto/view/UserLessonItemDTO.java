package com.exadel.mooc.dto.view;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserLessonItemDTO implements Serializable {
    private Long lessonItemId;
    private String lessonItemName;
    private int order;
    private String content;
    private String titleImg;
    private Long lessonId;
    private Long userId;
    private String status;
}
