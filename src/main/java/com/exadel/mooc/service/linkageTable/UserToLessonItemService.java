package com.exadel.mooc.service.linkageTable;

import com.exadel.mooc.repository.linkageTable.IUserToLessonItemRepository;
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
        if (!lessonItemRepository.findByUserIdAndLessonItemId(userId, lessonItemId).isPresent()) {
            lessonItemRepository.setStatusFinishedByUserIdAndLessonItemId(lessonItemId, userId);
        } else {
            //типо логирование ошибки)
            System.out.println("skip adding entity with userID=" + userId + " and lessonItemID=" + lessonItemId);
        }
    }
}
