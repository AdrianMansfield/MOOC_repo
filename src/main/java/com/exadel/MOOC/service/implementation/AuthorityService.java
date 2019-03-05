package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.IAuthorityRepository;
import com.exadel.MOOC.service.IAuthorityService;
import com.exadel.MOOC.dto.AuthorityDTO;
import com.exadel.MOOC.entity.Authority;
import com.exadel.MOOC.mapper.AuthorityMapper;
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
        Optional<Authority> authorityOptional = authorityRepository.findById(id);
        if (authorityOptional.isPresent()) {
            return Optional.of(authorityMapper.toDTO(authorityOptional.get()));
        } else throw new RuntimeException("not found authority with id " + id);
    }
}