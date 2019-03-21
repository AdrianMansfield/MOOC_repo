package com.exadel.mooc.dto.view;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserCourseDTO implements Serializable {
    private Long courseId;
    private String title;
    private Long creatorId;
    private Long userId;
    private String status;
}
