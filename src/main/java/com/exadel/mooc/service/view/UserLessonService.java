package com.exadel.mooc.service.view;

import com.exadel.mooc.repository.view.UserLessonViewRepository;
import com.exadel.mooc.dto.view.UserLessonDTO;
import com.exadel.mooc.mapper.view.UserLessonMapper;
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

    @Override
    public List<UserLessonDTO> findByUserId(Long userId) {
        return userLessonViewRepository.findByUserId(userId).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }
}
