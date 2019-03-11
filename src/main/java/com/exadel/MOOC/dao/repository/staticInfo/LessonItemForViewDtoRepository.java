package com.exadel.MOOC.dao.repository.staticInfo;

import com.exadel.MOOC.dto.staticInfo.LessonItemForViewDto;
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
public class LessonItemForViewDtoRepository implements ILessonItemForViewDto {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<LessonItemForViewDto> findLessonItemForViewDtoByUserIdAndLessonId(Long userId, Long lessonId) {
        Query query = entityManager.createNativeQuery(
                "select uliv.lesson_item_id as lessonItemId," +
                        "uliv.name as name," +
                        "uliv.order as \"order\"," +
                        "uliv.lesson_id as lessonId," +
                        "uliv.user_id as userId," +
                        "uliv.status as status " +
                        "from user_lesson_item_view uliv " +
                        "where uliv.user_id=:userId and uliv.lesson_id=:lessonId")
                .setParameter("userId", userId)
                .setParameter("lessonId", lessonId)
                .unwrap(NativeQuery.class)
                .addScalar("lessonItemId", LongType.INSTANCE)
                .addScalar("name", StringType.INSTANCE)
                .addScalar("order", IntegerType.INSTANCE)
                .addScalar("lessonId", LongType.INSTANCE)
                .addScalar("userId", LongType.INSTANCE)
                .addScalar("status", StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(LessonItemForViewDto.class));
        return query.getResultList();
    }
}
