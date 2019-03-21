package com.exadel.mooc.dto.staticInfo;

import com.exadel.mooc.dto.UserForViewDTO;
import com.exadel.mooc.dto.view.UserModuleDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CourseForViewDto {
    private Long id;
    private String title;
    private UserForViewDTO creator;
    private String status;
    private List<UserModuleDTO> moduleDTOS;
}
