package com.exadel.mooc.service.linkageTable;

import com.exadel.mooc.entity.linkageTable.UserToCourse;

public interface IUserToCourseService {

    int countAllByUserIdAndCourseId(Long userId, Long courseId);

    void save(UserToCourse userToCourse);

    void updateStatusByUserIdAndLessonItemId(Long lessonItemId, Long userId);
}
