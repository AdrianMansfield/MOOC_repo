package com.exadel.mooc.service.linkagetable;

import com.exadel.mooc.entity.linkagetable.UserToCourse;

public interface IUserToCourseService {

    int countAllByUserIdAndCourseId(Long userId, Long courseId);

    void save(UserToCourse userToCourse);

    void updateStatusByUserIdAndLessonItemId(Long lessonItemId, Long userId);
}
