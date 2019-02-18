package com.project.mooc.moocproject.dao.service.module.implementation;

import com.project.mooc.moocproject.dao.repository.ModuleRepository;
import com.project.mooc.moocproject.dao.service.module.ModuleService;
import com.project.mooc.moocproject.dto.ModuleDTO;
import com.project.mooc.moocproject.mapper.ModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleServiceImplementation implements ModuleService {

    @Autowired
    private ModuleMapper mapper;

    @Autowired
    private ModuleRepository moduleRepository;

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
}
