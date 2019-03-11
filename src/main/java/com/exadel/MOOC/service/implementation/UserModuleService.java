package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.implementation.UserModuleViewRepository;
import com.exadel.MOOC.dto.view.UserModuleDTO;
import com.exadel.MOOC.mapper.view.UserModuleMapper;
import com.exadel.MOOC.service.IUserModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserModuleService implements IUserModuleService {

    @Autowired
    private UserModuleViewRepository userModuleViewRepository;

    @Autowired
    private UserModuleMapper mapper;


    @Override
    public List<UserModuleDTO> findByUserIdAndModuleId(Long userId, Long moduleId) {
        return userModuleViewRepository.findByUserIdAndModuleId(userId, moduleId).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserModuleDTO> findByUserId(Long userId) {
        return userModuleViewRepository.findByUserId(userId).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserModuleDTO> findByUserIdAndCourseId(Long userId, Long courseId) {
        return userModuleViewRepository.findByUserIdAndCourseId(userId,courseId).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }
}
