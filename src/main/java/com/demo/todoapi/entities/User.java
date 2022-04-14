package com.demo.todoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table( name="users")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long userId;

    @Column(name ="user_name")
    private String userName;

    @JsonIgnore
    private String password;


    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL )
    @ToString.Exclude
    @JsonIgnore
    private Set<Todo> todos;

}
