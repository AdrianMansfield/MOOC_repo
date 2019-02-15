package com.project.mooc.moocproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "lessons_items")
@NoArgsConstructor
@AllArgsConstructor
public class LessonsItem implements Serializable {
    @Id
    @SequenceGenerator(name = "lesson_item_sequence", sequenceName = "lessons_items_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_item_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "order")
    private int order;

    @Column(name = "content")
    private String content;

    @Column(name = "title_img")
    private String title_img_link;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "users_lesson_items",
            joinColumns = @JoinColumn(name = "lesson_item_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> attendedUserList;
}
