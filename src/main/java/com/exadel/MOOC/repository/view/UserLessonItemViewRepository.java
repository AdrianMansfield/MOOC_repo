package com.exadel.MOOC.repository.view;

import com.exadel.MOOC.entity.view.UserLessonItem;
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
public class UserLessonItemViewRepository implements IUserLessonItemViewRepository {

    private static final String LESSON_ITEM_ID = "lessonItemId";
    private static final String USER_ID = "userId";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserLessonItem> findByUserIdAndLessonItemId(Long userId, Long lessonItemId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserLessonItem> criteriaQuery = criteriaBuilder.createQuery(UserLessonItem.class);
        Root<UserLessonItem> userLessonItemRoot = criteriaQuery.from(UserLessonItem.class);
        ParameterExpression<Long> userIdParam = criteriaBuilder.parameter(Long.class);
        ParameterExpression<Long> lessonItemIdParam = criteriaBuilder.parameter(Long.class);
        criteriaQuery
                .select(userLessonItemRoot)
                .where(criteriaBuilder.equal(userLessonItemRoot.get(USER_ID), userIdParam),
                        criteriaBuilder.equal(userLessonItemRoot.get(LESSON_ITEM_ID), lessonItemIdParam));
        TypedQuery<UserLessonItem> userLessonItemTypedQuery = entityManager.createQuery(criteriaQuery);
        userLessonItemTypedQuery.setParameter(userIdParam, userId);
        userLessonItemTypedQuery.setParameter(lessonItemIdParam, lessonItemId);
        return userLessonItemTypedQuery.getResultList();
    }

    @Override
    public List<UserLessonItem> findByUserId(Long userId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserLessonItem> criteriaQuery = criteriaBuilder.createQuery(UserLessonItem.class);
        Root<UserLessonItem> userLessonItemRoot = criteriaQuery.from(UserLessonItem.class);
        ParameterExpression<Long> userIdParam = criteriaBuilder.parameter(Long.class);
        criteriaQuery
                .select(userLessonItemRoot)
                .where(criteriaBuilder.equal(userLessonItemRoot.get(USER_ID), userIdParam));
        TypedQuery<UserLessonItem> userLessonItemTypedQuery = entityManager.createQuery(criteriaQuery);
        userLessonItemTypedQuery.setParameter(userIdParam, userId);
        return userLessonItemTypedQuery.getResultList();
    }
}
