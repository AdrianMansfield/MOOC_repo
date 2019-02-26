package com.project.mooc.moocproject.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorityDTO implements Serializable {
    private String name;
}
