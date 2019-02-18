package com.project.mooc.moocproject.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {
    private LocalDateTime dateOfSignUp;
    private String userName;
    private boolean isAdmin;

}
