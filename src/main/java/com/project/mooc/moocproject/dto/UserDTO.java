package com.project.mooc.moocproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {
    private LocalDateTime dateOfSignUp;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String pictureLink;
    private AuthorityDTO role;

}
