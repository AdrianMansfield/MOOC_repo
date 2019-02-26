package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dto.AuthorityDTO;
import com.project.mooc.moocproject.entity.Authority;
import org.springframework.stereotype.Component;

@Component
public class AuthorityMapper {

    public Authority toEntity(AuthorityDTO authorityDTO) {
        return Authority.builder()
                .name(authorityDTO.getName())
                .build();
    }

    public AuthorityDTO toDTO(Authority authority) {
        return AuthorityDTO.builder()
                .name(authority.getName())
                .build();
    }
}
