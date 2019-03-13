package com.exadel.MOOC.entity.linkageTable;

import com.exadel.MOOC.entity.itemType.ParentEntityStatus;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "users_lessons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class UserToLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "lessons_id")
    private Long lessonId;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "parent_entity_status")
    @Type(type = "pgsql_enum")
    private ParentEntityStatus status;
}

