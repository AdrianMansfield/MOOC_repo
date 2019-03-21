package com.exadel.mooc.converter;

import com.exadel.mooc.dto.UserForEditDTO;
import com.exadel.mooc.dto.UserForViewDTO;
import com.exadel.mooc.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class UserConverter {

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
                .id(user.getId())
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .pictureLink(user.getPictureLink())
                .build();
    }
}
