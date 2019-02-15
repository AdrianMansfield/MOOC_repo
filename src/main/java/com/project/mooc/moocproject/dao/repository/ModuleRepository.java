package com.project.mooc.moocproject.dao.repository;

import com.project.mooc.moocproject.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Long> {
}
