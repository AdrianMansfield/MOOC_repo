package com.exadel.MOOC.dao.repository;

import com.exadel.MOOC.entity.LessonsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonItemRepository extends JpaRepository<LessonsItem, Long> {
}
