package com.exadel.mooc.dto;

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
    private String titleImgLink;
    private int order;
    private Long courseId;
}
