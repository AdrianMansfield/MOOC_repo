package com.exadel.MOOC.dao.service.authority;

import com.exadel.MOOC.dto.AuthorityDTO;

import java.util.Optional;

public interface AuthorityService {

    Optional<AuthorityDTO> findById(Long id);
}
