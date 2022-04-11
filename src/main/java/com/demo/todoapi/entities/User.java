package com.demo.todoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name="users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name ="user_name")
    private String userName;

    @Column(name ="password")
    @JsonIgnore
    private String password;


    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL )
    @ToString.Exclude
    @JsonIgnore
    private Set<Todo> todos;

}
