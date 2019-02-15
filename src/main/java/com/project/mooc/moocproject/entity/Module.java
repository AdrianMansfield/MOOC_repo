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
@Table(name = "modules")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "lessonList")
public class Module implements Serializable {
    @Id
    @SequenceGenerator(name = "module_sequence", sequenceName = "modules_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "module_sequence")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "title_img")
    private String title_img_link;

    @Column(name = "order")
    private int order;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="module")
    private List<Lesson> lessonList;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "users_modules",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> attendedUserList;
}
