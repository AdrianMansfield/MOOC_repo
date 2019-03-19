package com.exadel.MOOC.repository.linkageTable;

import com.exadel.MOOC.entity.linkageTable.UserToLessonItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserToLessonItemRepository extends JpaRepository<UserToLessonItem, Long> {

    @Query(value = "select count(*) " +
            "from lessons_items " +
            "       left join users_lesson_items uli " +
            "                 on lessons_items.id = uli.lesson_item_id and user_id = :userId " +
            "where lesson_id = (select lesson_id from lessons_items where id = :lessonItemId) and (status not in ('finished') or status isnull)", nativeQuery = true)
    int countOfNotFinishedLessonItems(@Param("lessonItemId") Long lessonItemId,
                                      @Param("userId") Long userId);

    @Query(value = "select count(*) " +
            "from users_lesson_items " +
            "where user_id = :userId " +
            "  and (select lesson_id " +
            "       from lessons_items " +
            "       where lessons_items.id = :lessonItemId) = (select lesson_id " +
            "                                       from lessons_items " +
            "                                       where lessons_items.id = users_lesson_items.lesson_item_id)", nativeQuery = true)
    int countOfStartedLessonsItem(@Param("lessonItemId") Long lessonItemId,
                                  @Param("userId") Long userId);

    @Modifying
    @Query(value = "insert into users_lesson_items (user_id, lesson_item_id, status)" +
            "values (:userId, :lessonItemId, 'finished')", nativeQuery = true)
    void setStatusFinishedByUserIdAndLessonItemId(@Param("lessonItemId") Long lessonItemId,
                                                  @Param("userId") Long userId);

    Optional<UserToLessonItem> findByUserIdAndLessonItemId(Long userId, Long lessonItemId);
}
