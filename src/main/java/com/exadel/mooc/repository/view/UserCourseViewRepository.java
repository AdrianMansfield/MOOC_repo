package com.exadel.mooc.repository.view;

import com.exadel.mooc.entity.view.UserCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserCourseViewRepository implements IUserCourseViewRepository {

    private static final String COURSE_ID = "courseId";
    private static final String USER_ID = "userId";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserCourse> findByUserIdAndCourseId(Long userId, Long courseId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserCourse> criteriaQuery = criteriaBuilder.createQuery(UserCourse.class);
        Root<UserCourse> userCourseRoot = criteriaQuery.from(UserCourse.class);
        ParameterExpression<Long> userIdParam = criteriaBuilder.parameter(Long.class);
        ParameterExpression<Long> courseIdParam = criteriaBuilder.parameter(Long.class);
        criteriaQuery
                .select(userCourseRoot)
                .where(criteriaBuilder.equal(userCourseRoot.get(USER_ID), userIdParam),
                        criteriaBuilder.equal(userCourseRoot.get(COURSE_ID), courseIdParam)
                );
        TypedQuery<UserCourse> userCourseTypedQuery = entityManager.createQuery(criteriaQuery);
        userCourseTypedQuery.setParameter(userIdParam, userId);
        userCourseTypedQuery.setParameter(courseIdParam, courseId);
        return userCourseTypedQuery.getResultList();
    }

    @Override
    public List<UserCourse> findByUserId(Long userId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserCourse> criteriaQuery = criteriaBuilder.createQuery(UserCourse.class);
        Root<UserCourse> userCourseRoot = criteriaQuery.from(UserCourse.class);
        ParameterExpression<Long> userIdParam = criteriaBuilder.parameter(Long.class);
        criteriaQuery
                .select(userCourseRoot)
                .where(criteriaBuilder.equal(userCourseRoot.get(USER_ID), userIdParam));
        TypedQuery<UserCourse> userCourseTypedQuery = entityManager.createQuery(criteriaQuery);
        userCourseTypedQuery.setParameter(userIdParam, userId);
        return userCourseTypedQuery.getResultList();
    }
}
