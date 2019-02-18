package com.project.mooc.moocproject.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModuleDTO implements Serializable {
    private String title;
    private String description;
    private String title_img_link;
    private int order;
    private CourseDTO course;
}
