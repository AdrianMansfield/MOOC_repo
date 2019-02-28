package com.exadel.MOOC.mapper;

import com.exadel.MOOC.dto.UserForEditDTO;
import com.exadel.MOOC.dto.UserForViewDTO;
import com.exadel.MOOC.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User toEntity(UserForEditDTO userForEditDTO) {
        return User.builder()
                .userName(userForEditDTO.getUserName())
                .firstName(userForEditDTO.getFirstName())
                .lastName(userForEditDTO.getLastName())
                .email(userForEditDTO.getEmail())
                .password(userForEditDTO.getPassword())
                .pictureLink(userForEditDTO.getPictureLink())
                .dateOfSignUp(LocalDateTime.now())
                .build();

    }

    public UserForViewDTO toDTO(User user) {
        return UserForViewDTO.builder()
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .pictureLink(user.getPictureLink())
                .build();
    }
}
