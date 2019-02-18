package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dto.UserDTO;
import com.project.mooc.moocproject.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User toEntity(UserDTO userDTO) {
        return Objects.isNull(userDTO) ? null : modelMapper.map(userDTO, User.class);
    }

    public UserDTO toDTO(User user) {
        return Objects.isNull(user) ? null : modelMapper.map(user, UserDTO.class);
    }
}
