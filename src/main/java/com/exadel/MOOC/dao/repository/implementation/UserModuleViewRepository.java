package com.exadel.MOOC.dao.repository.implementation;

import com.exadel.MOOC.dao.repository.IUserModuleViewRepository;
import com.exadel.MOOC.entity.view.UserModule;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserModuleViewRepository implements IUserModuleViewRepository {

    private static final String USER_ID = "user_id";
    private static final String MODULE_ID = "id";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserModule> findByUserIdAndModuleId(Long userId, Long moduleId) {
        TypedQuery<UserModule> userModuleTypedQuery = entityManager.createQuery(getUserModuleCriteriaQuery());
        userModuleTypedQuery.setParameter(USER_ID, userId);
        userModuleTypedQuery.setParameter(MODULE_ID, moduleId);
        return userModuleTypedQuery.getResultList();
    }

    private CriteriaQuery<UserModule> getUserModuleCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<UserModule> criteriaQuery = criteriaBuilder.createQuery(UserModule.class);
        Root<UserModule> userModuleRoot = criteriaQuery.from(UserModule.class);
        criteriaQuery
                .select(userModuleRoot)
                .where(criteriaBuilder.equal(userModuleRoot.get(USER_ID), Long.class),
                        criteriaBuilder.equal(userModuleRoot.get(MODULE_ID), Long.class));
        return criteriaQuery;
    }
}
