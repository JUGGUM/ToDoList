package com.mysite.todo.ToDoList;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String content;

    @Column(nullable = false)
    private Boolean completed;
}
