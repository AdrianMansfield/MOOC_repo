package com.project.mooc.moocproject.dao.repository;

import com.project.mooc.moocproject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findTop3ByOrderByIdDesc();
}
