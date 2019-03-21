package com.exadel.mooc.converter;

import com.exadel.mooc.dto.AuthorityDTO;
import com.exadel.mooc.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class AuthorityConverter {

    public Role toEntity(AuthorityDTO authorityDTO) {
        log.info("Convert authorityDTO {} to entity", authorityDTO);
        return Role.builder()
                .name(authorityDTO.getName())
                .build();
    }

    public AuthorityDTO toDTO(Role authority) {
        log.info("Convert authority {} to authorityDTO", authority);
        return AuthorityDTO.builder()
                .name(authority.getName())
                .build();
    }
}
