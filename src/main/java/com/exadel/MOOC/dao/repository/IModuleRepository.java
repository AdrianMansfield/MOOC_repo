package com.exadel.MOOC.dao.repository;

import com.exadel.MOOC.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IModuleRepository extends JpaRepository<Module,Long> {

    List<Module> findByCourse_Id(Long courseId);
}
