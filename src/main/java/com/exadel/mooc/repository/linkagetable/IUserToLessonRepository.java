package com.exadel.mooc.repository.linkagetable;

import com.exadel.mooc.entity.linkagetable.UserToLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserToLessonRepository extends JpaRepository<UserToLesson, Long> {

    @Query(value = "select count(*) " +
            "from lessons " +
            "       left join users_lessons ul" +
            "                 on lessons.id = ul.lesson_id and user_id = :userId " +
            "where module_id = (select module_id from lessons where id = (select lesson_id from lessons_items where lessons_items.id = :lessonItemId)) " +
            "and (status not in ('FINISHED') or status isnull)", nativeQuery = true)
    int countOfNotFinishedLessons(@Param("lessonItemId") Long lessonItemId,
                                  @Param("userId") Long userId);

    @Query(value = "select count(*) " +
            "from users_lessons " +
            "where user_id = :userId " +
            "  and (select module_id " +
            "       from lessons " +
            "       where lessons.id = (select lesson_id " +
            "                           from lessons_items " +
            "                           where lessons_items.id = :lessonItemId)) = (select module_id " +
            "                                                                       from lessons " +
            "                                                                       where lessons.id = users_lessons.lesson_id)",
            nativeQuery = true)
    int countOfStartedLessons(@Param("lessonItemId") Long lessonItemId,
                              @Param("userId") Long userId);

    @Modifying
    @Query(value = "update users_lessons " +
            "set status = 'FINISHED' " +
            "where user_id = :userId " +
            "  and lesson_id = " +
            "      (select lesson_id " +
            "       from lessons_items " +
            "       where lessons_items.id = :lessonItemId)", nativeQuery = true)
    void updateStatusByUserIdAndLessonItemId(@Param("lessonItemId") Long lessonItemId,
                                             @Param("userId") Long userId);

    @Modifying
    @Query(value = "insert into users_lessons (user_id, lesson_id, status) " +
            "values (:userId, (select lesson_id " +
            "                  from lessons_items " +
            "                  where lessons_items.id = :lessonItemId)," +
            "       'IN_PROGRESS')", nativeQuery = true)
    void setStatusInProgressByUserIdAndLessonItemId(@Param("lessonItemId") Long lessonItemId,
                                                    @Param("userId") Long userId);
}
