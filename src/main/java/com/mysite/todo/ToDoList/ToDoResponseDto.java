package com.mysite.todo.ToDoList;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ToDoResponseDto {
    private Integer id;

    private String content;

    private Boolean completed;

    public ToDoResponseDto(ToDoEntity toDo){
        this.id = toDo.getId();
        this.content = toDo.getContent();
        this.completed = toDo.getCompleted();
    }
}
