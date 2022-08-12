package com.example.todolist.service;

import com.example.todolist.exception.BadRequestException;
import com.example.todolist.exception.NotFoundException;
import com.example.todolist.model.ToDo;
import com.example.todolist.request.CreateTodoRequest;
import com.example.todolist.request.UpdateTodoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ToDoService {
    private List<ToDo> toDos;

    public ToDoService() {
        toDos = new ArrayList<>();
        toDos.add(new ToDo(1,"play",true));
        toDos.add(new ToDo(2,"chill",false));
        toDos.add(new ToDo(3,"work-out",false));
        toDos.add(new ToDo(4,"swim",true));
        toDos.add(new ToDo(5,"exercise",false));
    }

    //lay danh sach tat ca cong viec
    public List<ToDo> getToDos(){
        return toDos;
    }

    //lay danh sach tat ca cong viec theo trang thai
    public List<ToDo> getToDos(boolean status){
        if (status){
            return toDos.stream()
                    .filter(ToDo::isStatus).collect(Collectors.toList());
        }
        return toDos.stream()
                .filter(toDo -> !toDo.isStatus()).collect(Collectors.toList());
    }
    //tao cv
    public ToDo createTodo(CreateTodoRequest request){
        if (request.getName().trim().equals("")){
            throw new BadRequestException("Not null");
        }
        Random rd = new Random();

        ToDo toDo = new ToDo(rd.nextInt(1000), request.getName(), false);
        toDos.add(toDo);
        return toDo;
    }
    //cap  nhat cv
    public ToDo updateTodo(int id, UpdateTodoRequest request){
        ToDo toDo = findById(id).orElseThrow(() ->{
            throw new NotFoundException("Not Found id = " +id );
        });
        toDo.setName(request.getName());
        toDo.setStatus(request.isStatus());
        return toDo;
    }
    //xoa cv
    public void deleteTodo(int id){
        ToDo toDo = findById(id).orElseThrow(() ->{
            throw new NotFoundException("Not Found id = " +id );
        });
        toDos.remove(toDo);
    }
    //findbyId
    public Optional<ToDo> findById( int id){
        return toDos.stream().filter(toDo -> toDo.getId()== id).findFirst();
    }
}
