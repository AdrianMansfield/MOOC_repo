package com.exadel.MOOC.service.authority.implementation;

import com.exadel.MOOC.dao.repository.AuthorityRepository;
import com.exadel.MOOC.service.authority.AuthorityService;
import com.exadel.MOOC.dto.AuthorityDTO;
import com.exadel.MOOC.entity.Authority;
import com.exadel.MOOC.mapper.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityServiceImplementation implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

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
