package com.exadel.MOOC.entity.linkageTable;

import com.exadel.MOOC.entity.itemType.ChildEntityStatus;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "users_lesson_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class UserToLessonItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "lesson_item_id")
    private Long lessonItemId;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "child_entity_status")
    @Type(type = "pgsql_enum")
    private ChildEntityStatus status;
}
