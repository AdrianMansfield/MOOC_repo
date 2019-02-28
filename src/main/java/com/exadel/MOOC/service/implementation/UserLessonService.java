package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.implementation.UserLessonViewRepository;
import com.exadel.MOOC.dto.view.UserLessonDTO;
import com.exadel.MOOC.mapper.view.UserLessonMapper;
import com.exadel.MOOC.service.IUserLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserLessonService implements IUserLessonService {

    @Autowired
    private UserLessonViewRepository userLessonViewRepository;

    @Autowired
    private UserLessonMapper mapper;


    @Override
    public List<UserLessonDTO> findByUserIdAndLessonId(Long userId, Long lessonId) {
        return userLessonViewRepository.findByUserIdAndLessonId(userId, lessonId).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }
}
