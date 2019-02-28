package com.exadel.MOOC.dao.repository.implementation;

import com.exadel.MOOC.dao.repository.IUserCourseViewRepository;
import com.exadel.MOOC.entity.view.UserCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserCourseViewRepository implements IUserCourseViewRepository {

    private static final String COURSE_ID = "id";
    private static final String USER_ID = "user_id";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserCourse> findByUserIdAndCourseId(Long userId, Long courseId) {
        TypedQuery<UserCourse> userCourseTypedQuery = entityManager.createQuery(getUserCourseCriteriaQuery());
        userCourseTypedQuery.setParameter(USER_ID, userId);
        userCourseTypedQuery.setParameter(COURSE_ID, courseId);
        return userCourseTypedQuery.getResultList();
    }

    private CriteriaQuery<UserCourse> getUserCourseCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<UserCourse> criteriaQuery = criteriaBuilder.createQuery(UserCourse.class);
        Root<UserCourse> userCourseRoot = criteriaQuery.from(UserCourse.class);
        criteriaQuery
                .select(userCourseRoot)
                .where(criteriaBuilder.equal(userCourseRoot.get(USER_ID), Long.class),
                        criteriaBuilder.equal(userCourseRoot.get(COURSE_ID), Long.class));
        return criteriaQuery;
    }
}
