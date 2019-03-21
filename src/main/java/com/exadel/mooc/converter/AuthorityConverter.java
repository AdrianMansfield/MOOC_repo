package com.exadel.mooc.converter;

import com.exadel.mooc.dto.AuthorityDTO;
import com.exadel.mooc.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class AuthorityConverter {

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
