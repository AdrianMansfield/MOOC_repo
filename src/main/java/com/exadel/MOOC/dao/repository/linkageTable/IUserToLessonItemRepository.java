package com.exadel.MOOC.dao.repository.linkageTable;

import com.exadel.MOOC.entity.linkageTable.UserToLessonItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserToLessonItemRepository extends JpaRepository<UserToLessonItem, Long> {
}
