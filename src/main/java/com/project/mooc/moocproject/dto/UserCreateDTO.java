package com.project.mooc.moocproject.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserCreateDTO implements Serializable {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String pictureLink;
}
