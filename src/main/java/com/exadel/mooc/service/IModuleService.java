package com.exadel.mooc.service;

import com.exadel.mooc.dto.ModuleDTO;

import java.util.List;

public interface IModuleService {

    void save(ModuleDTO moduleDTO);

    void deleteByID(Long id);

    void update(ModuleDTO moduleDTO);

    List<ModuleDTO> findAll();

    List<ModuleDTO> findByCourseId(Long courseId);
}
