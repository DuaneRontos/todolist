package com.example.todolist.service;

import com.example.todolist.dto.ToDo;
import com.example.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }
  System.out.println("breaking changes");
    public void createToDo(ToDo toDo){




        System.out.println("master changes");
        if (toDo.getTitle().equalsIgnoreCase("Title")) {
            toDoRepository.save(toDo);
        }
        else if (toDo.getTitle().equalsIgnoreCase("Duane")) {
            throw new RuntimeException("Sorry");
        }
        toDoRepository.save(toDo);
    }

    public List<ToDo> getToDos(){
        return toDoRepository.findAll();
    }


    public ToDo getToDo(Integer id){
        return toDoRepository.findById(id);
    }

    public void deleteToDo(Integer id){
        toDoRepository.delete(id);
    }


    public void updateToDo(Integer id, ToDo toDo){
        toDo.setId(id);
        toDoRepository.save(toDo);
    }
}
