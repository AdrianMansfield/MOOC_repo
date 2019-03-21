package com.exadel.mooc.service;

import com.exadel.mooc.entity.itemtype.ParentEntityStatus;
import com.exadel.mooc.entity.linkagetable.UserToCourse;
import com.exadel.mooc.service.linkagetable.IUserToCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CourseSubscriptionService implements ICourseSubscriptionService {

    @Autowired
    private IUserToCourseService userToCourseService;

    @Override
    @Transactional
    public boolean subscribe(Long userId, Long courseId) {
        boolean result = true;
        if (userToCourseService.countAllByUserIdAndCourseId(userId, courseId) > 0) {
            result = false;
        } else {
            userToCourseService.save(new UserToCourse(null, userId, courseId, ParentEntityStatus.IN_PROGRESS));
        }
        return result;
    }
}
