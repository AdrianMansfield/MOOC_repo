package com.exadel.mooc.entity.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_course_view")
@NoArgsConstructor
@Getter
@Setter
public class UserCourse {

    @Id
    private Long id;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "title")
    private String title;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    private String status;
}
