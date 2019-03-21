package com.exadel.mooc.repository;

import com.exadel.mooc.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByModuleId(Long moduleId);
}
