package com.exadel.MOOC.dao.repository.implementation;

import com.exadel.MOOC.dao.repository.IUserLessonItemViewRepository;
import com.exadel.MOOC.entity.view.UserLessonItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserLessonItemViewRepository implements IUserLessonItemViewRepository {

    private static final String LESSON_ITEM_ID = "id";
    private static final String USER_ID = "user_id";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserLessonItem> findByUserIdAndLessonItemId(Long userId, Long lessonItemId) {
        TypedQuery<UserLessonItem> userLessonItemTypedQuery = entityManager.createQuery(getUserLessonItemsCriteriaQuery());
        userLessonItemTypedQuery.setParameter(USER_ID, userId);
        userLessonItemTypedQuery.setParameter(LESSON_ITEM_ID, lessonItemId);
        return userLessonItemTypedQuery.getResultList();
    }

    private CriteriaQuery<UserLessonItem> getUserLessonItemsCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<UserLessonItem> criteriaQuery = criteriaBuilder.createQuery(UserLessonItem.class);
        Root<UserLessonItem> userLessonItemRoot = criteriaQuery.from(UserLessonItem.class);
        criteriaQuery
                .select(userLessonItemRoot)
                .where(criteriaBuilder.equal(userLessonItemRoot.get(USER_ID), Long.class),
                        criteriaBuilder.equal(userLessonItemRoot.get(LESSON_ITEM_ID), Long.class));
        return criteriaQuery;
    }
}
