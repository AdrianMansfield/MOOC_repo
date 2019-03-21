package com.exadel.mooc.service;

import com.exadel.mooc.dto.AuthorityDTO;

import java.util.Optional;

public interface IAuthorityService {

    Optional<AuthorityDTO> findById(Long id);
}
