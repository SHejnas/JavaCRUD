package org.slhejnas.microservices.MyFirstJava.controller;

import org.slhejnas.microservices.MyFirstJava.model.ToDo;
import org.slhejnas.microservices.MyFirstJava.service.ToDoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    private final ToDoService toDoService;
    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }
    @PostMapping
    public ToDo createToDo(@RequestBody ToDo toDo){
        return toDoService.insertToDo(toDo);
    }
    @GetMapping
    public String GetAllToDo(){
        return "Study Spring Boot";
    }

}

