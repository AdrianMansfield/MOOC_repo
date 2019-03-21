package com.exadel.mooc.repository;

import com.exadel.mooc.entity.LessonsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILessonItemRepository extends JpaRepository<LessonsItem, Long> {
}
