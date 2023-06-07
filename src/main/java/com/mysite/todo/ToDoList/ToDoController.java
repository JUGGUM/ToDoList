package com.mysite.todo.ToDoList;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ToDoController {

    private final ToDoService toDoService;

    @RequestMapping("/todo")
    public String list(Model model){
        List<ToDoEntity> toDoEntityList = this.toDoService.getList();
        System.out.println(toDoEntityList);
        model.addAttribute("toDoEntityList", toDoEntityList);
        return"todolist";
    }
    @RequestMapping("/")
    public String root(){
        return "redirect:/todo";
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
