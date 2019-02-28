package com.exadel.MOOC.dao.repository;

import com.exadel.MOOC.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findById(Long id);
}
