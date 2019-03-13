package com.exadel.MOOC.dto.staticInfo;

import com.exadel.MOOC.dto.UserForViewDTO;
import com.exadel.MOOC.dto.view.UserModuleDTO;
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
