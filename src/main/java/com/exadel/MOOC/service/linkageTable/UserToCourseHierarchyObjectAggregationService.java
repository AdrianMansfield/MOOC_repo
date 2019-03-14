package com.exadel.MOOC.service.linkageTable;

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
        if (userToLessonItemService.countOfStartedLessonsItem(lessonItemId, userId) == 0) {
            if (userToLessonService.countOfStartedLessons(lessonItemId, userId) == 0) {
                userToModuleService.setStatusInProgressByUserIdAndLessonItemId(lessonItemId, userId);
            }
            userToLessonService.setStatusInProgressByUserIdAndLessonItemId(lessonItemId, userId);
        }
        userToLessonItemService.setStatusFinishedByUserIdAndLessonItemId(lessonItemId, userId);
        if (userToLessonItemService.countOfNotFinishedLessonItems(lessonItemId, userId) == 0) {
            userToLessonService.updateStatusByUserIdAndLessonItemId(lessonItemId, userId);
            if (userToLessonService.countOfNotFinishedLessons(lessonItemId, userId) == 0) {
                userToModuleService.updateStatusByUserIdAndLessonItemId(lessonItemId, userId);
                if (userToModuleService.countOfNotFinishedModules(lessonItemId, userId) == 0) {
                    userToCourseService.updateStatusByUserIdAndLessonItemId(lessonItemId, userId);
                }
            }
        }
    }
}
