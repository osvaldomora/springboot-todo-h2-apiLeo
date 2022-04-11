package com.demo.todoapi.repositories;

import com.demo.todoapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * http://localhost:8080/todoapp/api/h2-console
 */
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByUserNameAndPassword(String userName, String password);

}
