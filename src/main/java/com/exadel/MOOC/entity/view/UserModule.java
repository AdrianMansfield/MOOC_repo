package com.exadel.MOOC.entity.view;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Immutable
@Table(name = "user_module_view")
@NoArgsConstructor
@Getter
public class UserModule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "title_img")
    private String title_img;

    @Column(name = "order")
    private int order;

    @Column(name = "course_id")
    private Long course_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "status")
    private String status;
}
