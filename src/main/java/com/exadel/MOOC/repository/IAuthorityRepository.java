package com.exadel.MOOC.repository;

import com.exadel.MOOC.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthorityRepository extends JpaRepository<Role, Long> {
    Optional<Role> findById(Long id);
}
