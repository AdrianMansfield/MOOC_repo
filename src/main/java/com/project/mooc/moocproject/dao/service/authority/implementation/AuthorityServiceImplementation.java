package com.project.mooc.moocproject.dao.service.authority.implementation;

import com.project.mooc.moocproject.dao.repository.AuthorityRepository;
import com.project.mooc.moocproject.dao.service.authority.AuthorityService;
import com.project.mooc.moocproject.dto.AuthorityDTO;
import com.project.mooc.moocproject.entity.Authority;
import com.project.mooc.moocproject.mapper.AuthorityMapper;
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
