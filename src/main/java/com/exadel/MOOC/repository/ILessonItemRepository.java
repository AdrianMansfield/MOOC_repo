package com.exadel.MOOC.repository;

import com.exadel.MOOC.entity.LessonsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILessonItemRepository extends JpaRepository<LessonsItem, Long> {
}
