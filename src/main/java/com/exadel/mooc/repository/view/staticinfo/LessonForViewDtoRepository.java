package com.exadel.mooc.repository.view.staticinfo;

import com.exadel.mooc.dto.staticinfo.LessonForViewDTO;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@SuppressWarnings("deprecation")
public class LessonForViewDtoRepository implements ILessonForViewDto {

    private static final String USER_ID = "userId";
    private static final String MODULE_ID = "moduleId";
    private static final String LESSON_ID = "lessonId";
    private static final String TITLE = "title";
    private static final String ORDER = "order";
    private static final String STATUS = "status";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<LessonForViewDTO> findLessonForViewDtoByUserIdAndModuleId(Long userId, Long moduleId) {
        Query query = entityManager.createNativeQuery("select ulv.lesson_id as lessonId," +
                "ulv.title as title," +
                "ulv.order as \"order\"," +
                "ulv.module_id as moduleId," +
                "ulv.user_id as userId," +
                "ulv.status as status " +
                "from user_lesson_view ulv " +
                "where (ulv.user_id=:userId or ulv.user_id = -99) and ulv.module_id=:moduleId order by \"order\"")
                .setParameter(USER_ID, userId)
                .setParameter(MODULE_ID, moduleId)
                .unwrap(NativeQuery.class)
                .addScalar(LESSON_ID, LongType.INSTANCE)
                .addScalar(TITLE, StringType.INSTANCE)
                .addScalar(ORDER, IntegerType.INSTANCE)
                .addScalar(MODULE_ID, LongType.INSTANCE)
                .addScalar(USER_ID, LongType.INSTANCE)
                .addScalar(STATUS, StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(LessonForViewDTO.class));
        return query.getResultList();
    }
}
