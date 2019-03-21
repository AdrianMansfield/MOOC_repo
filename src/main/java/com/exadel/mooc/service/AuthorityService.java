package com.exadel.mooc.service;

import com.exadel.mooc.repository.IAuthorityRepository;
import com.exadel.mooc.dto.AuthorityDTO;
import com.exadel.mooc.entity.Role;
import com.exadel.mooc.converter.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityService implements IAuthorityService {

    @Autowired
    private IAuthorityRepository authorityRepository;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public Optional<AuthorityDTO> findById(Long id) {
        Optional<Role> authorityOptional = authorityRepository.findById(id);
        if (authorityOptional.isPresent()) {
            return Optional.of(authorityMapper.toDTO(authorityOptional.get()));
        } else throw new RuntimeException("not found authority with id " + id);
    }
}
