package com.exadel.MOOC.mapper;

import com.exadel.MOOC.dto.AuthorityDTO;
import com.exadel.MOOC.entity.Authority;
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
