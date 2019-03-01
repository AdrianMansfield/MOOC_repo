package com.exadel.MOOC.dao.repository.implementation;

import com.exadel.MOOC.dao.repository.IUserModuleViewRepository;
import com.exadel.MOOC.entity.view.UserModule;
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
public class UserModuleViewRepository implements IUserModuleViewRepository {

    private static final String USER_ID = "userId";
    private static final String MODULE_ID = "moduleId";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserModule> findByUserIdAndModuleId(Long userId, Long moduleId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserModule> criteriaQuery = criteriaBuilder.createQuery(UserModule.class);
        Root<UserModule> userModuleRoot = criteriaQuery.from(UserModule.class);
        ParameterExpression<Long> userIdParam = criteriaBuilder.parameter(Long.class);
        ParameterExpression<Long> moduleIdParam = criteriaBuilder.parameter(Long.class);
        criteriaQuery
                .select(userModuleRoot)
                .where(criteriaBuilder.equal(userModuleRoot.get(USER_ID), userIdParam),
                        criteriaBuilder.equal(userModuleRoot.get(MODULE_ID), moduleIdParam));
        TypedQuery<UserModule> userModuleTypedQuery = entityManager.createQuery(criteriaQuery);
        userModuleTypedQuery.setParameter(userIdParam, userId);
        userModuleTypedQuery.setParameter(moduleIdParam, moduleId);
        return userModuleTypedQuery.getResultList();
    }

    @Override
    public List<UserModule> findByUserId(Long userId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserModule> criteriaQuery = criteriaBuilder.createQuery(UserModule.class);
        Root<UserModule> userModuleRoot = criteriaQuery.from(UserModule.class);
        ParameterExpression<Long> userIdParam = criteriaBuilder.parameter(Long.class);
        criteriaQuery
                .select(userModuleRoot)
                .where(criteriaBuilder.equal(userModuleRoot.get(USER_ID), userIdParam));
        TypedQuery<UserModule> userModuleTypedQuery = entityManager.createQuery(criteriaQuery);
        userModuleTypedQuery.setParameter(userIdParam, userId);
        return userModuleTypedQuery.getResultList();
    }
}
