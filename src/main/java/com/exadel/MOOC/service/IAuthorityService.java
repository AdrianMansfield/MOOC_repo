package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.AuthorityDTO;

import java.util.Optional;

public interface IAuthorityService {

    Optional<AuthorityDTO> findById(Long id);
}
