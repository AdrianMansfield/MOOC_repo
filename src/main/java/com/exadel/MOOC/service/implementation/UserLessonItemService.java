package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.implementation.UserLessonItemViewRepository;
import com.exadel.MOOC.dto.view.UserLessonItemDTO;
import com.exadel.MOOC.mapper.view.UserLessonItemMapper;
import com.exadel.MOOC.service.IUserLessonItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserLessonItemService implements IUserLessonItemService {

    @Autowired
    private UserLessonItemMapper mapper;

    @Autowired
    private UserLessonItemViewRepository userLessonItemViewRepository;


    @Override
    public List<UserLessonItemDTO> findByUserIdAndLessonItemId(Long userId, Long lessonItemId) {
        return userLessonItemViewRepository.findByUserIdAndLessonItemId(userId, lessonItemId).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserLessonItemDTO> findByUserId(Long userId) {
        return userLessonItemViewRepository.findByUserId(userId).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }
}
