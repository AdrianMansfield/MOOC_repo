package com.exadel.mooc.converter;

import com.exadel.mooc.dto.UserForEditDTO;
import com.exadel.mooc.dto.UserForViewDTO;
import com.exadel.mooc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Slf4j
public class UserConverter {

    public User toEntity(UserForEditDTO userForEditDTO) {
        log.info("Convert userForEditDTO {} to entity", userForEditDTO);
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
        log.info("Convert User {} to DTO", user);
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
