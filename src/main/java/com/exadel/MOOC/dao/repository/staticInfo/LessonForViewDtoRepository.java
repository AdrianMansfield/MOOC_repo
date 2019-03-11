package com.exadel.MOOC.dao.repository.staticInfo;

import com.exadel.MOOC.dto.staticInfo.LessonForViewDto;
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

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<LessonForViewDto> findLessonForViewDtoByUserIdAndModuleId(Long userId, Long moduleId) {
        Query query = entityManager.createNativeQuery("select ulv.lesson_id as lessonId," +
                "ulv.title as title," +
                "ulv.order as \"order\"," +
                "ulv.module_id as moduleId," +
                "ulv.user_id as userId," +
                "ulv.status as status " +
                "from user_lesson_view ulv " +
                "where ulv.user_id=:userId and ulv.module_id=:moduleId")
                .setParameter("userId", userId)
                .setParameter("moduleId", moduleId)
                .unwrap(NativeQuery.class)
                .addScalar("lessonId", LongType.INSTANCE)
                .addScalar("title", StringType.INSTANCE)
                .addScalar("order", IntegerType.INSTANCE)
                .addScalar("moduleId", LongType.INSTANCE)
                .addScalar("userId", LongType.INSTANCE)
                .addScalar("status", StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(LessonForViewDto.class));
        return query.getResultList();
    }
}
