package com.example.todolist.controller;


import com.example.todolist.dto.ToDo;
import com.example.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ToDoController {

    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @PostMapping("/todos")
    public void createToDo(@RequestBody ToDo toDo){
        toDoService.createToDo(toDo);
    }

    @GetMapping("/todos")
    public List<ToDo> getToDos() {
        return toDoService.getToDos();
    }

    @GetMapping("/todos/{id}")
    public ToDo getToDo(@PathVariable Integer id){
        return toDoService.getToDo(id);
    }


    @PutMapping("/todos/{id}")
    public void updateToDo(@PathVariable Integer id, @RequestBody ToDo toDo){
        toDoService.updateToDo(id, toDo);
    }

    @DeleteMapping("todos/{id}")
    public void deleteToDo(@PathVariable Integer id){
        toDoService.deleteToDo((id));
    }

}
