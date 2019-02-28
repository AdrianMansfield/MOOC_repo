package com.exadel.MOOC.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserForEditDTO implements Serializable {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String pictureLink;
}
