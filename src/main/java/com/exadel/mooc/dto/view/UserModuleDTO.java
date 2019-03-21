package com.exadel.mooc.dto.view;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserModuleDTO implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String titleImg;
    private int order;
    private Long courseId;
    private Long userId;
    private String status;
}
