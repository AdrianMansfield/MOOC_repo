package com.exadel.mooc.service.linkagetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserToCourseHierarchyObjectAggregationService implements IUserToCourseHierarchyObjectAggregationService {

    @Autowired
    private IUserToLessonItemService userToLessonItemService;

    @Autowired
    private IUserToLessonService userToLessonService;

    @Autowired
    private IUserToModuleService userToModuleService;

    @Autowired
    private IUserToCourseService userToCourseService;

    @Override
    public void setStatusForLessonItem(final Long lessonItemId, final Long userId) {
        if (isFirstFinishedLessonItemFromLesson(lessonItemId, userId)) {
            if (isFirstFinishedLessonFromModule(lessonItemId, userId)) {
                userToModuleService.setStatusInProgressByUserIdAndLessonItemId(lessonItemId, userId);
            }
            userToLessonService.setStatusInProgressByUserIdAndLessonItemId(lessonItemId, userId);
        }


        userToLessonItemService.setStatusFinishedByUserIdAndLessonItemId(lessonItemId, userId);
        if (userToLessonItemService.countOfNotFinishedLessonItems(lessonItemId, userId) != 0) {
            return;
        }

        userToLessonService.updateStatusByUserIdAndLessonItemId(lessonItemId, userId);
        if (userToLessonService.countOfNotFinishedLessons(lessonItemId, userId) != 0) {
            return;
        }

        userToModuleService.updateStatusByUserIdAndLessonItemId(lessonItemId, userId);
        if (userToModuleService.countOfNotFinishedModules(lessonItemId, userId) != 0) {
            return;
        }

        userToCourseService.updateStatusByUserIdAndLessonItemId(lessonItemId, userId);
    }

    private boolean isFirstFinishedLessonFromModule(Long lessonItemId, Long userId) {
        return userToLessonService.countOfStartedLessons(lessonItemId, userId) == 0;
    }

    private boolean isFirstFinishedLessonItemFromLesson(Long lessonItemId, Long userId) {
        return userToLessonItemService.countOfStartedLessonsItem(lessonItemId, userId) == 0;
    }
}
