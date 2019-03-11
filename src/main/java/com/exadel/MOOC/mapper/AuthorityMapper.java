package com.exadel.MOOC.mapper;

import com.exadel.MOOC.dto.AuthorityDTO;
import com.exadel.MOOC.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class AuthorityMapper {

    public Role toEntity(AuthorityDTO authorityDTO) {
        return Role.builder()
                .name(authorityDTO.getName())
                .build();
    }

    public AuthorityDTO toDTO(Role authority) {
        return AuthorityDTO.builder()
                .name(authority.getName())
                .build();
    }
}
