package com.project.mooc.moocproject.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "modules")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Module extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "title_img")
    private String title_img_link;

    @Column(name = "order")
    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
