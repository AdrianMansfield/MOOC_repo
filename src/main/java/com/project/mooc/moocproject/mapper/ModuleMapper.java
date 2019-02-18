package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dto.ModuleDTO;
import com.project.mooc.moocproject.entity.Module;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ModuleMapper {

    @Autowired
    private ModelMapper mapper;

    public ModuleDTO toDTO(Module module) {
        return Objects.isNull(module) ? null : mapper.map(module, ModuleDTO.class);
    }

    public Module toEntity(ModuleDTO moduleDTO) {
        return Objects.isNull(moduleDTO) ? null : mapper.map(moduleDTO, Module.class);
    }
}
