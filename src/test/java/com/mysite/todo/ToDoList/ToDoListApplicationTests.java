package com.mysite.todo.ToDoList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToDoListApplicationTests {

	@Autowired
	private ToDoRepository todoRepository;

	@Test
	void testJpa(){
		ToDoEntity todo1 = new ToDoEntity();
		todo1.setContent("밥먹기");
		todo1.setCompleted(Boolean.TRUE);
		this.todoRepository.save(todo1);

		ToDoEntity todo2 = new ToDoEntity();
		todo2.setContent("스프링 공부하기");
		todo2.setCompleted(Boolean.FALSE);
		this.todoRepository.save(todo2);
	}
	@Test
	void contextLoads() {
	}

}
