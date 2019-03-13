package com.exadel.MOOC.dao.repository.linkageTable;

import com.exadel.MOOC.entity.linkageTable.UserToLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserToLessonRepository extends JpaRepository<UserToLesson, Long> {
}
