package com.exadel.mooc.service.linkageTable;

public interface IUserToLessonItemService {

    int countOfNotFinishedLessonItems(Long lessonItemId, Long userId);

    int countOfStartedLessonsItem(Long lessonItemId, Long userId);

    void setStatusFinishedByUserIdAndLessonItemId(Long lessonItemId, Long userId);
}
