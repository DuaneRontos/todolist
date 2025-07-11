package com.example.todolist.repository;

import com.example.todolist.dto.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ToDoRepository {

    Map<Integer, ToDo> map = new HashMap<>();
    int id = 0;

    public void save(ToDo toDo){

        if(map.containsKey(toDo.getId())){
            ToDo toDo1 = map.get(toDo.getId());

            toDo1.setTitle(toDo.getTitle());
            toDo1.setDescription(toDo.getDescription());

            map.put(toDo.getId(), toDo1);

        }

        else{
            map.put(++id, toDo);
        }
    }

    public List<ToDo> findAll(){
        List<ToDo> toDos = new ArrayList<>();

        for(Map.Entry<Integer, ToDo> entry: map.entrySet()){
            ToDo toDo = new ToDo(entry.getKey(), entry.getValue().getTitle(), entry.getValue().getDescription());
            toDos.add(toDo);
        }

        return toDos;
    }


    public ToDo findById(Integer id){

        ToDo toDo = map.get(id);
        if(toDo == null){
            return null;
        }

        return new ToDo(id, toDo.getTitle(), toDo.getDescription());
    }

    public void delete(Integer id){
        map.remove(id);
    }

}
