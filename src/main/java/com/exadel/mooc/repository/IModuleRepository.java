package com.exadel.mooc.repository;

import com.exadel.mooc.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IModuleRepository extends JpaRepository<Module,Long> {

    List<Module> findByCourseId(Long courseId);
}
