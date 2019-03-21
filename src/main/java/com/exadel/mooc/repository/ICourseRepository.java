package com.exadel.mooc.repository;

import com.exadel.mooc.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    List<Course> findTop3ByOrderByIdDesc();
}
