package com.project.mooc.moocproject.dao.service.Authority;

import com.project.mooc.moocproject.dto.AuthorityDTO;

import java.util.Optional;

public interface AuthorityService {

    Optional<AuthorityDTO> findById(Long id);
}
