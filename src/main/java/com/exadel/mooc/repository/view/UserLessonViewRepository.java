package com.exadel.mooc.repository.view;

import com.exadel.mooc.entity.view.UserLesson;
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
public class UserLessonViewRepository implements IUserLessonViewRepository {

    private static final String USER_ID = "userId";
    private static final String LESSON_ID = "lessonId";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserLesson> findByUserIdAndLessonId(Long userId, Long lessonId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserLesson> criteriaQuery = criteriaBuilder.createQuery(UserLesson.class);
        Root<UserLesson> userLessonItemRoot = criteriaQuery.from(UserLesson.class);
        ParameterExpression<Long> userIdParam = criteriaBuilder.parameter(Long.class);
        ParameterExpression<Long> lessonIdParam = criteriaBuilder.parameter(Long.class);
        criteriaQuery
                .select(userLessonItemRoot)
                .where(criteriaBuilder.equal(userLessonItemRoot.get(USER_ID), userIdParam),
                        criteriaBuilder.equal(userLessonItemRoot.get(LESSON_ID), lessonIdParam));
        TypedQuery<UserLesson> userLessonTypedQuery = entityManager.createQuery(criteriaQuery);
        userLessonTypedQuery.setParameter(userIdParam, userId);
        userLessonTypedQuery.setParameter(lessonIdParam, lessonId);
        return userLessonTypedQuery.getResultList();
    }

    @Override
    public List<UserLesson> findByUserId(Long userId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserLesson> criteriaQuery = criteriaBuilder.createQuery(UserLesson.class);
        Root<UserLesson> userLessonItemRoot = criteriaQuery.from(UserLesson.class);
        ParameterExpression<Long> userIdParam = criteriaBuilder.parameter(Long.class);
        criteriaQuery
                .select(userLessonItemRoot)
                .where(criteriaBuilder.equal(userLessonItemRoot.get(USER_ID), userIdParam));
        TypedQuery<UserLesson> userLessonTypedQuery = entityManager.createQuery(criteriaQuery);
        userLessonTypedQuery.setParameter(userIdParam, userId);
        return userLessonTypedQuery.getResultList();
    }
}
