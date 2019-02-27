package com.project.mooc.moocproject.dao.service.authority;

import com.project.mooc.moocproject.dto.AuthorityDTO;

import java.util.Optional;

public interface AuthorityService {

    Optional<AuthorityDTO> findById(Long id);
}
