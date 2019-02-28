package com.exadel.MOOC.dao.repository;

import com.exadel.MOOC.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByModule_Id(Long moduleId);
}
