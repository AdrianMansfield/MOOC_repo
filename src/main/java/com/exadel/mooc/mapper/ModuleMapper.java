package com.exadel.mooc.mapper;

import com.exadel.mooc.repository.ICourseRepository;
import com.exadel.mooc.dto.ModuleDTO;
import com.exadel.mooc.entity.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModuleMapper {

    @Autowired
    private ICourseRepository courseRepository;

    public ModuleDTO toDTO(Module module) {
        return ModuleDTO.builder()
                .title(module.getTitle())
                .description(module.getDescription())
                .title_img_link(module.getTitle_img_link())
                .order(module.getOrder())
                .courseId(module.getCourse().getId())
                .id(module.getId())
                .build();
    }

    public Module toEntity(ModuleDTO moduleDTO) {
        return Module.builder()
                .title(moduleDTO.getTitle())
                .description(moduleDTO.getDescription())
                .title_img_link(moduleDTO.getTitle_img_link())
                .order(moduleDTO.getOrder())
                .course(courseRepository.findById(moduleDTO.getCourseId())
                        .orElseThrow(() -> new RuntimeException("module mapper error")))
                .build();
    }
}
