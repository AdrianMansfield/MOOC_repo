package com.project.mooc.moocproject.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "lessons_items")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LessonsItem extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "order")
    private int order;

    @Column(name = "content")
    private String content;

    @Column(name = "title_img")
    private String title_img_link;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;
}
