package com.exadel.MOOC.repository.view.staticInfo;

import com.exadel.MOOC.dto.staticInfo.ModuleForViewDto;
import com.exadel.MOOC.entity.view.UserModule;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@SuppressWarnings("deprecation")
public class ModuleForViewDtoRepository implements IModuleForViewDto {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<ModuleForViewDto> findModuleForViewDtoByUserIdAndModuleId(Long userId, Long moduleId) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(UserModule.class);
        criteria.add(Expression.eq("moduleId", moduleId));
        criteria.add(Restrictions.disjunction()
                .add(Restrictions.eq("userId", userId))
                .add(Restrictions.eq("userId", -99L)))
                .setProjection(
                        Projections.projectionList()
                                .add(Projections.property("moduleId"))
                                .add(Projections.property("title"))
                                .add(Projections.property("userId"))
                                .add(Projections.property("status")))
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] tuple, String[] aliases) {
                        return new ModuleForViewDto(
                                (Long) tuple[0],
                                (String) tuple[1],
                                (Long) tuple[2],
                                (String) tuple[3]);
                    }

                    @Override
                    public List transformList(List collection) {
                        return collection;
                    }
                });
        if (criteria.list().isEmpty()) {
            return Optional.of(new ModuleForViewDto());
        } else {
            return Optional.of((ModuleForViewDto) criteria.list().get(0));
        }
    }
}
