package com.project.mooc.moocproject.dao.service.module;

import com.project.mooc.moocproject.dto.ModuleDTO;

import java.util.List;

public interface ModuleService {

    void save(ModuleDTO moduleDTO);

    void deleteByID(Long id);

    void update(ModuleDTO moduleDTO);

    List<ModuleDTO> findAll();
}
