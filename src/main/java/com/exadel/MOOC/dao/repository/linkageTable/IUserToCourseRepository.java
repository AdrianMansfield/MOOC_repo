package com.exadel.MOOC.dao.repository.linkageTable;

import com.exadel.MOOC.entity.linkageTable.UserToCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserToCourseRepository extends JpaRepository<UserToCourse, Long> {

    int countAllByUserIdAndCourseId(Long userId, Long courseId);

    @Modifying
    @Query(value = "update users_courses " +
            "set status = 'finished'" +
            "where user_id = :userId " +
            "  and course_id = (select course_id " +
            "                 from modules " +
            "                 where modules.id = " +
            "                       (select module_id " +
            "                        from lessons " +
            "                        where lessons.id = " +
            "                              (select lesson_id " +
            "                               from lessons_items " +
            "                               where lessons_items.id = :lessonItemId)))", nativeQuery = true)
    void updateStatusByUserIdAndLessonItemId(@Param("lessonItemId") Long lessonItemId,
                                             @Param("userId") Long userId);

}
