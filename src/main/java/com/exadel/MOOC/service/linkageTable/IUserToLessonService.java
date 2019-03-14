package com.exadel.MOOC.service.linkageTable;

public interface IUserToLessonService {

    int countOfNotFinishedLessons(Long lessonItemId, Long userId);

    int countOfStartedLessons(Long lessonItemId, Long userId);

    void updateStatusByUserIdAndLessonItemId(Long lessonItemId, Long userId);

    void setStatusInProgressByUserIdAndLessonItemId(Long lessonItemId, Long userId);
}
