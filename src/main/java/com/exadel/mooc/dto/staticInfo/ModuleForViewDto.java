package com.exadel.mooc.dto.staticInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModuleForViewDto {
    private Long moduleId;
    private String title;
    private Long userId;
    private String status;
    private List<LessonForViewDto> lessonForViewDtos;

    public ModuleForViewDto(Long moduleId, String title, Long userId, String status) {
        this.moduleId = moduleId;
        this.title = title;
        this.userId = userId;
        this.status = status;
    }
}
