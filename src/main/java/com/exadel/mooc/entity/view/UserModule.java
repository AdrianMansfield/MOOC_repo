package com.exadel.mooc.entity.view;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_module_view")
@NoArgsConstructor
@Getter
public class UserModule {

    @Column(name = "module_id")
    private Long moduleId;

    @Column(name = "title")
    private String title;

    @Id
    @Column(name = "description")
    private String description;

    @Column(name = "title_img")
    private String titleImg;

    @Column(name = "order")
    private int order;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status", nullable = false)
    private String status;
}
