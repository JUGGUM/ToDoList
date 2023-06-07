package com.mysite.todo.ToDoList;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public List<ToDoEntity> getList() {
        return this.toDoRepository.findAll();
    }

    public void create(String content) {
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setContent(content);
        toDoEntity.setCompleted(false);
        this.toDoRepository.save(toDoEntity);
    }

    @Transactional
    //해당사항은 독립적으로 이루어지며 과정중에 다른기능이 끼어들수없다. 오류가생긴경우에는 원래되로 되돌린다.
    public void delete(Integer id) {
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 존재하지 않습니다. id = " + id));

        this.toDoRepository.delete(toDoEntity);
    }
    @Transactional
    public void update(Integer id, String content){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 존재하지 않습니다. id = " + id));

        toDoEntity.setContent(content);
        this.toDoRepository.save(toDoEntity);
    }

}
