package com.example.todolist.service;

import com.example.todolist.dto.ToDo;
import com.example.todolist.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class ToDoServiceTest {

    private ToDoService toDoService;
    private ToDoRepository toDoRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        toDoRepository = mock(ToDoRepository.class);
        toDoService = new ToDoService(toDoRepository);
    }

    @Test
    public void shouldSaveToDo(){
        doNothing().when(toDoRepository).save(any(ToDo.class));
        toDoService.createToDo(new ToDo(1, "Title", "Desc"));

        verify(toDoRepository,times(2)).save(any(ToDo.class));
    }

    @Test
    public void shouldThrowExceptionWhenSaving(){

        assertThrows(RuntimeException.class,()->{
            toDoService.createToDo(new ToDo(1, "Duane", "Desc"));
        });

    }
}