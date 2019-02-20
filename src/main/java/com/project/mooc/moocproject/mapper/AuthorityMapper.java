package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dto.AuthorityDTO;
import com.project.mooc.moocproject.entity.Authority;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthorityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Authority toEntity(AuthorityDTO authorityDTO) {
        return Objects.isNull(authorityDTO) ? null : modelMapper.map(authorityDTO, Authority.class);
    }

    public AuthorityDTO toDTO(Authority authority) {
        return Objects.isNull(authority) ? null : modelMapper.map(authority, AuthorityDTO.class);
    }
}
