package com.mysite.todo.ToDoList;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;

@RequiredArgsConstructor
@Data
public class ToDoResponseDto {
    private Integer id;

    private String content;

    private Boolean completed;
}
