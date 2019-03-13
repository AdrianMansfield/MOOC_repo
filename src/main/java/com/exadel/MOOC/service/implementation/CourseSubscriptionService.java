package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.linkageTable.IUserToCourseRepository;
import com.exadel.MOOC.entity.itemType.ParentEntityStatus;
import com.exadel.MOOC.entity.linkageTable.UserToCourse;
import com.exadel.MOOC.service.ICourseSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CourseSubscriptionService implements ICourseSubscriptionService {

    @Autowired
    private IUserToCourseRepository userToCourseRepository;

    @Override
    @Transactional
    public boolean subscribe(Long userId, Long courseId) {
        boolean result = true;
        if (userToCourseRepository.countAllByUserIdAndCourseId(userId, courseId) > 0) {
            result = false;
        } else {
            userToCourseRepository.save(new UserToCourse(null, userId, courseId, ParentEntityStatus.in_progress));
        }
        return result;
    }

//    @Override
//    @Transactional
//    public boolean unsubscribe(Long userId, Long courseId) {
//        boolean result = true;
//        try {
//            userToCourseRepository.deleteByUserIdAndCourseId(userId, courseId);
//        } catch (Exception e) {
//            result = false;
//            System.out.println("issue with deleting user from linkage table");
//            e.printStackTrace();
//        }
//        return result;
//    }

//    @Override
//    public boolean isSubscribed(Long userId, Long courseId) {
//        boolean result = false;
//        if (userToCourseRepository.countAllByUserIdAndCourseId(userId, courseId) > 0)
//            result = true;
//        return result;
//    }
}
