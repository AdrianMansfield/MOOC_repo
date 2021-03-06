package com.exadel.mooc.converter;

import com.exadel.mooc.dto.ModuleDTO;
import com.exadel.mooc.entity.Module;
import com.exadel.mooc.exception.EntityNotFoundException;
import com.exadel.mooc.repository.ICourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ModuleConverter {

    @Autowired
    private ICourseRepository courseRepository;

    public ModuleDTO toDTO(Module module) {
        log.info("Convert module {} to DTO", module);
        return ModuleDTO.builder()
                .title(module.getTitle())
                .description(module.getDescription())
                .titleImgLink(module.getTitleImgLink())
                .order(module.getOrder())
                .courseId(module.getCourse().getId())
                .id(module.getId())
                .build();
    }

    public Module toEntity(ModuleDTO moduleDTO) {
        log.info("Convert moduleDTO {} to entity", moduleDTO);
        return Module.builder()
                .title(moduleDTO.getTitle())
                .description(moduleDTO.getDescription())
                .titleImgLink(moduleDTO.getTitleImgLink())
                .order(moduleDTO.getOrder())
                .course(courseRepository.findById(moduleDTO.getCourseId())
                        .orElseThrow(() -> new EntityNotFoundException("can not find course by id:" + moduleDTO.getCourseId())))
                .build();
    }
}
