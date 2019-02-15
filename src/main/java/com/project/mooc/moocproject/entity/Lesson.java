package com.project.mooc.moocproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "lessons")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "lessonsItemList")
public class Lesson implements Serializable {
    @Id
    @SequenceGenerator(name = "lesson_sequence", sequenceName = "lessons_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_sequence")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "order")
    private int order;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "module_id")
    private Module module;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<LessonsItem> lessonsItemList;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "users_lessons",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> attendedUserList;
}
