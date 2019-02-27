package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dao.repository.CourseRepository;
import com.project.mooc.moocproject.dto.ModuleDTO;
import com.project.mooc.moocproject.entity.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModuleMapper {

    @Autowired
    private CourseRepository courseRepository;

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