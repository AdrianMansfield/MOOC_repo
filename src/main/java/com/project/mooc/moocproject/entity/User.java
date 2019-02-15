package com.project.mooc.moocproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "courseList")
public class User implements Serializable {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "users_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    @Column(name = "date_of_sign_up")
    private LocalDateTime dateOfSignUp;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Course> createdCourseList;

    @ManyToMany(mappedBy = "attendedUserList", fetch = FetchType.LAZY)
    private List<Course> courseList;

    @ManyToMany(mappedBy = "attendedUserList", fetch = FetchType.LAZY)
    private List<Module> moduleList;

    @ManyToMany(mappedBy = "attendedUserList", fetch = FetchType.LAZY)
    private List<Lesson> lessonList;

    @ManyToMany(mappedBy = "attendedUserList", fetch = FetchType.LAZY)
    private List<LessonsItem> lessonsItemList;
}
