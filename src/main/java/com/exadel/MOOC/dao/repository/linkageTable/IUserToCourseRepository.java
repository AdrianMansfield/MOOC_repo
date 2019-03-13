package com.exadel.MOOC.dao.repository.linkageTable;

import com.exadel.MOOC.entity.linkageTable.UserToCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserToCourseRepository extends JpaRepository<UserToCourse, Long> {

    int countAllByUserIdAndCourseId(Long userId, Long courseId);

//    void deleteByUserIdAndCourseId(Long userId, Long courseId);
}
