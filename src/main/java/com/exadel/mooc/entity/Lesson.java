package com.exadel.mooc.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "lessons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Lesson extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "order")
    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(nullable = false, name = "module_id")
    private Module module;
}
