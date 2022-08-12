package com.example.todolist.controller;

import com.example.todolist.model.ToDo;
import com.example.todolist.request.CreateTodoRequest;
import com.example.todolist.request.UpdateTodoRequest;
import com.example.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todos")
    public List<ToDo> getTodos(@RequestParam Optional<Boolean> status){
        if (status.isPresent()){
            return toDoService.getToDos(status.get());
        }else {
            return toDoService.getToDos();
        }

    }

    @PostMapping ("/todos")
    public ToDo createTodo(@RequestBody CreateTodoRequest request){
        return toDoService.createTodo(request);
    }

    @PutMapping("/todos")
    public ToDo updateTodo(@RequestParam int id, @RequestBody UpdateTodoRequest request){
        return toDoService.updateTodo(id, request);
    }

    @DeleteMapping("/todos")
    public void deleteTodo(@RequestParam int id){
        toDoService.deleteTodo(id);
    }
}
