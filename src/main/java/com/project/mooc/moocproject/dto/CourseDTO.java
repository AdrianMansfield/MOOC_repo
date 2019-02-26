package com.project.mooc.moocproject.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CourseDTO implements Serializable {
    private Long id;
    private String title;
    private UserViewDTO creator;

}
