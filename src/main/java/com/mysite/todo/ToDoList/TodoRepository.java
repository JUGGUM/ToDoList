package com.mysite.todo.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer> {
    //JPA
}
