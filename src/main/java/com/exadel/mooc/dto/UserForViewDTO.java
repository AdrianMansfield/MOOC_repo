package com.exadel.mooc.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserForViewDTO implements Serializable {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String pictureLink;
}
