package com.exadel.mooc.service.linkagetable;

import com.exadel.mooc.repository.linkagetable.IUserToLessonItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class UserToLessonItemService implements IUserToLessonItemService {

    @Autowired
    private IUserToLessonItemRepository lessonItemRepository;

    @Override
    public int countOfNotFinishedLessonItems(Long lessonItemId, Long userId) {
        return lessonItemRepository.countOfNotFinishedLessonItems(lessonItemId, userId);
    }

    @Override
    public int countOfStartedLessonsItem(Long lessonItemId, Long userId) {
        return lessonItemRepository.countOfStartedLessonsItem(lessonItemId, userId);
    }

    @Override
    public void setStatusFinishedByUserIdAndLessonItemId(Long lessonItemId, Long userId) {
        if (!lessonItemRepository.findByUserIdAndLessonItemId(userId, lessonItemId).isPresent()) {
            lessonItemRepository.setStatusFinishedByUserIdAndLessonItemId(lessonItemId, userId);
        } else {
            log.error("Skip adding entity with userId:{} and lessonItemId: {}", userId, lessonItemId);
        }
    }
}
