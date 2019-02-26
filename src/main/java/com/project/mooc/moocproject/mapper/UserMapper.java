package com.project.mooc.moocproject.mapper;

import com.project.mooc.moocproject.dto.UserCreateDTO;
import com.project.mooc.moocproject.dto.UserViewDTO;
import com.project.mooc.moocproject.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User toEntity(UserCreateDTO userCreateDTO) {
        return User.builder()
                .userName(userCreateDTO.getUserName())
                .firstName(userCreateDTO.getFirstName())
                .lastName(userCreateDTO.getLastName())
                .email(userCreateDTO.getEmail())
                .password(userCreateDTO.getPassword())
                .pictureLink(userCreateDTO.getPictureLink())
                .dateOfSignUp(LocalDateTime.now())
                .build();

    }

    public UserViewDTO toDTO(User user) {
        return UserViewDTO.builder()
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .pictureLink(user.getPictureLink())
                .build();
    }
}
