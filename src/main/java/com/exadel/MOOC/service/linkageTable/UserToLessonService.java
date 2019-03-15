package com.exadel.MOOC.service.linkageTable;

import com.exadel.MOOC.repository.linkageTable.IUserToLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserToLessonService implements IUserToLessonService {

    @Autowired
    private IUserToLessonRepository userToLessonRepository;

    @Override
    public int countOfNotFinishedLessons(Long lessonItemId, Long userId) {
        return userToLessonRepository.countOfNotFinishedLessons(lessonItemId, userId);
    }

    @Override
    public int countOfStartedLessons(Long lessonItemId, Long userId) {
        return userToLessonRepository.countOfStartedLessons(lessonItemId, userId);
    }

    @Transactional
    @Override
    public void updateStatusByUserIdAndLessonItemId(Long lessonItemId, Long userId) {
        userToLessonRepository.updateStatusByUserIdAndLessonItemId(lessonItemId, userId);
    }

    @Transactional
    @Override
    public void setStatusInProgressByUserIdAndLessonItemId(Long lessonItemId, Long userId) {
        userToLessonRepository.setStatusInProgressByUserIdAndLessonItemId(lessonItemId, userId);
    }
}
