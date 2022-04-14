package com.demo.todoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "todos")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String title;

    private String description;

    @Column(name = "is_completed")
    private Boolean completed;


    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "created_by", insertable = false, updatable = false  )
    @ToString.Exclude
    @JsonIgnore
    private User user;

}
