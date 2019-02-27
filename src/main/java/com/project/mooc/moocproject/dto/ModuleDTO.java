package com.project.mooc.moocproject.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModuleDTO implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String title_img_link;
    private int order;
    private Long courseId;
}
