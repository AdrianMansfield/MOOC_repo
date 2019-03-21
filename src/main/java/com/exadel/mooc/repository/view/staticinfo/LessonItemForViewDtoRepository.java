package com.exadel.mooc.repository.view.staticinfo;

import com.exadel.mooc.dto.staticinfo.LessonItemForViewDTO;
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

    private static final String USER_ID = "userId";
    private static final String LESSON_ID = "lessonId";
    private static final String LESSON_ITEM_ID = "lessonItemId";
    private static final String NAME = "name";
    private static final String ORDER = "order";
    private static final String STATUS = "status";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<LessonItemForViewDTO> findLessonItemForViewDtoByUserIdAndLessonId(Long userId, Long lessonId) {
        Query query = entityManager.createNativeQuery(
                "select uliv.lesson_item_id as lessonItemId," +
                        "uliv.name as name," +
                        "uliv.order as \"order\"," +
                        "uliv.lesson_id as lessonId," +
                        "uliv.user_id as userId," +
                        "uliv.status as status " +
                        "from user_lesson_item_view uliv " +
                        "where (uliv.user_id=:userId or uliv.user_id = -99) and uliv.lesson_id=:lessonId order by \"order\"")
                .setParameter(USER_ID, userId)
                .setParameter(LESSON_ID, lessonId)
                .unwrap(NativeQuery.class)
                .addScalar(LESSON_ITEM_ID, LongType.INSTANCE)
                .addScalar(NAME, StringType.INSTANCE)
                .addScalar(ORDER, IntegerType.INSTANCE)
                .addScalar(LESSON_ID, LongType.INSTANCE)
                .addScalar(USER_ID, LongType.INSTANCE)
                .addScalar(STATUS, StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(LessonItemForViewDTO.class));
        return query.getResultList();
    }
}
