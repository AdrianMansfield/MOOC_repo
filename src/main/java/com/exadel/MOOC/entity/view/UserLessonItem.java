package com.exadel.MOOC.entity.view;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "user_lesson_item_view")
@NoArgsConstructor
@Getter
public class UserLessonItem {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "order")
    private int order;

    @Column(name = "content")
    private String content;

    @Column(name = "title_img")
    private String titleImg;

    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    private String status;
}
