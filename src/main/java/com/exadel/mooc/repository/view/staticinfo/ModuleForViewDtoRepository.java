package com.exadel.mooc.repository.view.staticinfo;

import com.exadel.mooc.dto.staticinfo.ModuleForViewDTO;
import com.exadel.mooc.entity.view.UserModule;
import org.hibernate.Criteria;
import org.hibernate.Session;
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

    private static final long EMPTY_USER_ID_VALUE = -99L;
    private static final String USER_ID = "userId";
    private static final String MODULE_ID = "moduleId";
    private static final String TITLE = "title";
    private static final String STATUS = "status";

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<ModuleForViewDTO> findModuleForViewDtoByUserIdAndModuleId(Long userId, Long moduleId) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(UserModule.class);
        criteria.add(Restrictions.eq(MODULE_ID, moduleId));
        criteria.add(Restrictions.disjunction()
                .add(Restrictions.eq(USER_ID, userId))
                .add(Restrictions.eq(USER_ID, EMPTY_USER_ID_VALUE)))
                .setProjection(
                        Projections.projectionList()
                                .add(Projections.property(MODULE_ID))
                                .add(Projections.property(TITLE))
                                .add(Projections.property(USER_ID))
                                .add(Projections.property(STATUS)))
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] tuple, String[] aliases) {
                        return new ModuleForViewDTO(
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
            return Optional.of(new ModuleForViewDTO());
        } else {
            return Optional.of((ModuleForViewDTO) criteria.list().get(0));
        }
    }
}
