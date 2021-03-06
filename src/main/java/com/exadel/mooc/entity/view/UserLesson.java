package com.exadel.mooc.entity.view;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_lesson_view")
@NoArgsConstructor
@Getter
public class UserLesson {

    @Id
    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "title")
    private String title;

    @Column(name = "order")
    private int order;

    @Column(name = "module_id")
    private Long moduleId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    private String status;
}
