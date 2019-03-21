package com.exadel.mooc.service.view;

import com.exadel.mooc.repository.view.UserLessonItemViewRepository;
import com.exadel.mooc.dto.view.UserLessonItemDTO;
import com.exadel.mooc.converter.view.UserLessonItemConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserLessonItemService implements IUserLessonItemService {

    @Autowired
    private UserLessonItemConverter mapper;

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
