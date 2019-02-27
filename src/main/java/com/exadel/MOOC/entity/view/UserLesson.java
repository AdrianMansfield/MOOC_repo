package com.exadel.MOOC.entity.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Immutable
@Table(name = "user_lesson_view")
@NoArgsConstructor
@Getter
public class UserLesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
