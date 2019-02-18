package com.project.mooc.moocproject.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LessonDTO implements Serializable {
    private String title;
    private int order;
    private ModuleDTO module;
}
