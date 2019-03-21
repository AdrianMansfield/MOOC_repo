package com.exadel.mooc.service.linkagetable;

import com.exadel.mooc.repository.linkagetable.IUserToCourseRepository;
import com.exadel.mooc.entity.linkagetable.UserToCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserToCourseService implements IUserToCourseService {

    @Autowired
    private IUserToCourseRepository userToCourseRepository;

    @Override
    public int countAllByUserIdAndCourseId(Long userId, Long courseId) {
        return userToCourseRepository.countAllByUserIdAndCourseId(userId, courseId);
    }

    @Override
    public void save(UserToCourse userToCourse) {
        userToCourseRepository.save(userToCourse);
    }

    @Transactional
    @Override
    public void updateStatusByUserIdAndLessonItemId(Long lessonItemId, Long userId) {
        userToCourseRepository.updateStatusByUserIdAndLessonItemId(lessonItemId, userId);
    }
}
