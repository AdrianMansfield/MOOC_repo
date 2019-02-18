package com.project.mooc.moocproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_sign_up")
    private LocalDateTime dateOfSignUp;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "is_admin")
    private boolean isAdmin;
}
