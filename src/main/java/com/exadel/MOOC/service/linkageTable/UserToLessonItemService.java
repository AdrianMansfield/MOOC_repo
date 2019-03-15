package com.exadel.MOOC.service.linkageTable;

import com.exadel.MOOC.repository.linkageTable.IUserToLessonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
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

    @Transactional
    @Override
    public void setStatusFinishedByUserIdAndLessonItemId(Long lessonItemId, Long userId) {
        lessonItemRepository.setStatusFinishedByUserIdAndLessonItemId(lessonItemId, userId);
    }
}
