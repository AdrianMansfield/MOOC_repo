package com.exadel.MOOC.service;

import com.exadel.MOOC.entity.itemType.ParentEntityStatus;
import com.exadel.MOOC.entity.linkageTable.UserToCourse;
import com.exadel.MOOC.service.ICourseSubscriptionService;
import com.exadel.MOOC.service.linkageTable.IUserToCourseService;
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
            userToCourseService.save(new UserToCourse(null, userId, courseId, ParentEntityStatus.in_progress));
        }
        return result;
    }
}
