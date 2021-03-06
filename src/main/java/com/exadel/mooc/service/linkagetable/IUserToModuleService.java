package com.exadel.mooc.service.linkagetable;

public interface IUserToModuleService {

    int countOfNotFinishedModules(Long lessonItemId, Long userId);

    int countOfStartedModules(Long lessonItemId, Long userId);

    void updateStatusByUserIdAndLessonItemId(Long lessonItemId, Long userId);

    void setStatusInProgressByUserIdAndLessonItemId(Long lessonItemId, Long userId);
}
