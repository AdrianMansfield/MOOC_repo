package com.exadel.mooc.service;

import com.exadel.mooc.converter.ModuleConverter;
import com.exadel.mooc.dto.ModuleDTO;
import com.exadel.mooc.repository.IModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleService implements IModuleService {

    @Autowired
    private ModuleConverter mapper;

    @Autowired
    private IModuleRepository moduleRepository;

    @Override
    public void save(ModuleDTO moduleDTO) {
        moduleRepository.save(mapper.toEntity(moduleDTO));
    }

    @Override
    public void deleteByID(Long id) {
        moduleRepository.deleteById(id);
    }

    @Override
    public void update(ModuleDTO moduleDTO) {
        moduleRepository.save(mapper.toEntity(moduleDTO));
    }

    @Override
    public List<ModuleDTO> findAll() {
        return moduleRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ModuleDTO> findByCourseId(Long courseId) {
        return moduleRepository.findByCourseId(courseId).stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
