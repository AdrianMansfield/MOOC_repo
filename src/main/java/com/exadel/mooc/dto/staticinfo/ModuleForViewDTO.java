package com.exadel.mooc.dto.staticinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModuleForViewDTO {
    private Long moduleId;
    private String title;
    private Long userId;
    private String status;
    private List<LessonForViewDTO> lessonForViewDTOS;

    public ModuleForViewDTO(Long moduleId, String title, Long userId, String status) {
        this.moduleId = moduleId;
        this.title = title;
        this.userId = userId;
        this.status = status;
    }
}
