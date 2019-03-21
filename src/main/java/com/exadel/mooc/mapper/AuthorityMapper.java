package com.exadel.mooc.mapper;

import com.exadel.mooc.dto.AuthorityDTO;
import com.exadel.mooc.entity.Role;
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
