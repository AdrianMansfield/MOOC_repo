package com.exadel.MOOC.entity.view;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Immutable
@Table(name = "user_lesson_item")
@NoArgsConstructor
@Getter
public class UserLessonItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "order")
    private int order;

    @Column(name = "content")
    private String content;

    @Column(name = "title_img")
    private String title_img;

    @Column(name = "lesson_id")
    private Long lesson_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "status")
    private String status;
}
