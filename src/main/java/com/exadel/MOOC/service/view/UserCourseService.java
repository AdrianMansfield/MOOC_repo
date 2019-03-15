package com.exadel.MOOC.service.view;

import com.exadel.MOOC.repository.view.UserCourseViewRepository;
import com.exadel.MOOC.dto.view.UserCourseDTO;
import com.exadel.MOOC.mapper.view.UserCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCourseService implements IUserCourseService {

    @Autowired
    private UserCourseMapper mapper;

    @Autowired
    private UserCourseViewRepository userCourseViewRepository;


    @Override
    public List<UserCourseDTO> findByUserIdAndCourseId(Long userId, Long courseId) {
        return userCourseViewRepository.findByUserIdAndCourseId(userId, courseId).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserCourseDTO> findByUserId(Long userId) {
        return userCourseViewRepository.findByUserId(userId).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }
}
