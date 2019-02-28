package com.exadel.MOOC.dao.repository.implementation;

import com.exadel.MOOC.dao.repository.IUserLessonViewRepository;
import com.exadel.MOOC.entity.view.UserLesson;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserLessonViewRepository implements IUserLessonViewRepository {

    private static final String USER_ID = "user_id";
    private static final String LESSON_ID = "id";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserLesson> findByUserIdAndLessonId(Long userId, Long lessonId) {
        TypedQuery<UserLesson> userLessonTypedQuery = entityManager.createQuery(getUserLessonsCriteriaQuery());
        userLessonTypedQuery.setParameter(USER_ID, userId);
        userLessonTypedQuery.setParameter(LESSON_ID, lessonId);
        return userLessonTypedQuery.getResultList();
    }

    private CriteriaQuery<UserLesson> getUserLessonsCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<UserLesson> criteriaQuery = criteriaBuilder.createQuery(UserLesson.class);
        Root<UserLesson> userLessonItemRoot = criteriaQuery.from(UserLesson.class);
        criteriaQuery
                .select(userLessonItemRoot)
                .where(criteriaBuilder.equal(userLessonItemRoot.get(USER_ID), Long.class),
                        criteriaBuilder.equal(userLessonItemRoot.get(LESSON_ID), Long.class));
        return criteriaQuery;
    }
}
