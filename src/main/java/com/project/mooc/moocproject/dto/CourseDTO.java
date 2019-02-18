package com.project.mooc.moocproject.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseDTO implements Serializable {
    private String title;
    private UserDTO creator;

}
