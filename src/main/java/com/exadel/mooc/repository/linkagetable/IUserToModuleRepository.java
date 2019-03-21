package com.exadel.mooc.repository.linkagetable;

import com.exadel.mooc.entity.linkagetable.UserToModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserToModuleRepository extends JpaRepository<UserToModule, Long> {

    @Query(value = "select count(*) " +
            "from modules " +
            "       left join users_modules um" +
            "                 on modules.id = um.module_id and user_id = :userId " +
            "where course_id = (select course_id " +
            "                   from modules " +
            "                   where id = (select module_id " +
            "                               from lessons " +
            "                               where lessons.id = " +
            "                                 (select lesson_id " +
            "                                  from lessons_items " +
            "                                  where lessons_items.id = :lessonItemId))) and (status not in ('FINISHED') or status isnull)",
            nativeQuery = true)
    int countOfNotFinishedModules(@Param("lessonItemId") Long lessonItemId, @Param("userId") Long userId);

    @Query(value = "select count(*) " +
            "from users_modules " +
            "where user_id = :userId " +
            "  and (select course_id " +
            "       from modules " +
            "       where modules.id = (select module_id " +
            "                           from lessons " +
            "                           where lessons.id = " +
            "                                 (select lesson_id " +
            "                                  from lessons_items " +
            "                                  where lessons_items.id = :lessonItemId))) = (select course_id " +
            "                                                                               from modules " +
            "                                                                               where modules.id = users_modules.module_id)",
            nativeQuery = true)
    int countOfStartedModules(@Param("lessonItemId") Long lessonItemId, @Param("userId") Long userId);

    @Modifying
    @Query(value = "update users_modules " +
            "set status = 'FINISHED' " +
            "where user_id = :userId " +
            "  and module_id = (select module_id " +
            "                   from lessons " +
            "                   where lessons.id = " +
            "                         (select lesson_id " +
            "                          from lessons_items " +
            "                          where lessons_items.id = :lessonItemId));", nativeQuery = true)
    void updateStatusByUserIdAndLessonItemId(@Param("lessonItemId") Long lessonItemId,
                                             @Param("userId") Long userId);

    @Modifying
    @Query(value = "insert into users_modules (user_id, module_id, status)\n" +
            "select :userId , module_id, 'IN_PROGRESS' " +
            "from lessons " +
            "where lessons.id = " +
            "      (select lesson_id " +
            "       from lessons_items " +
            "       where lessons_items.id = :lessonItemId)", nativeQuery = true)
    void setStatusInProgressByUserIdAndLessonItemId(@Param("lessonItemId") Long lessonItemId,
                                                    @Param("userId") Long userId);
}
