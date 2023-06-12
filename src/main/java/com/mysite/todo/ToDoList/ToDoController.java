package com.mysite.todo.ToDoList;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class ToDoController {

    private final ToDoService toDoService;

    @RequestMapping("/todo")
    public ResponseEntity<List<ToDoResponseDto>> list(Model model){
        List<ToDoEntity> toDoList = toDoService.findAll();
        List<ToDoResponseDto> responseDtos = new ArrayList<>();
//        model.addAttribute("toDoEntityList", toDoList);
        for(ToDoEntity toDo : toDoList){
            responseDtos.add(new ToDoResponseDto(toDo));
        }
        return ResponseEntity.ok(responseDtos);
    }
    @RequestMapping("/")
    public String root(){
        return "redirect:/todo";
    }

    @GetMapping("/todo/show/{id}")
    public ResponseEntity<Optional<ToDoEntity>> todoList(@PathVariable Integer id){
        Optional<ToDoEntity> toDoEntity = this.toDoService.findOne(id);
        return ResponseEntity.ok(toDoEntity);
    }
    @PostMapping("/todo/create")
    public String todoCreate(@RequestParam String content){
        this.toDoService.create(content);
        return "redirect:/todo";
    }

    @DeleteMapping("/todo/delete/{id}")
    public String todoDelete(@PathVariable Integer id){
        this.toDoService.delete(id);
        return "redirect:/todo";
    }

    @PutMapping("/todo/update/{id}")
    public String todoUpdate(@PathVariable Integer id,@RequestBody String content ){
        this.toDoService.update(id, content);
        return "redirect:/todo";
    }
}
