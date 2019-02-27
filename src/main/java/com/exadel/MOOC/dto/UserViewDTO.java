package com.exadel.MOOC.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserViewDTO implements Serializable {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String pictureLink;
}
