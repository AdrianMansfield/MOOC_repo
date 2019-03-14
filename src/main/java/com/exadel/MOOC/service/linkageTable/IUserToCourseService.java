package com.exadel.MOOC.service.linkageTable;

import com.exadel.MOOC.entity.linkageTable.UserToCourse;

public interface IUserToCourseService {

    int countAllByUserIdAndCourseId(Long userId, Long courseId);

    void save(UserToCourse userToCourse);

    void updateStatusByUserIdAndLessonItemId(Long lessonItemId, Long userId);
}
