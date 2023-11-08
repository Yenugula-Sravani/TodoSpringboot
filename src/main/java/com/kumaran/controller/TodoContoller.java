package com.kumaran.controller;

import com.kumaran.Model.Todo;
import com.kumaran.repository.Todorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/api")
public class TodoContoller {

    @Autowired
    Todorepository  todorepository;


    @GetMapping("/all")
    public List<Todo> getAllTodos(){
        return todorepository.findAll();
    }
    @GetMapping("/all/{id}")
    public Todo getTodo(@PathVariable int id){
        return todorepository.findById(id);
    }

    @PostMapping("/createtodo")
    public List<Todo> createTodo(@RequestBody Todo todo){
        todorepository.addTodo(todo);
        return todorepository.findAll();
    }

    @PutMapping("/updatetodo")
    public List<Todo> updateTodo(@RequestBody Todo todo){
        todorepository.updateTodo(todo);
        return todorepository.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public List<Todo> deleteTodo(@PathVariable  int id){
        todorepository.deleteTodo(id);
        return todorepository.findAll();
    }


}
