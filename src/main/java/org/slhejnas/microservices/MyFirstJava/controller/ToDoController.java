package org.slhejnas.microservices.MyFirstJava.controller;

import org.slhejnas.microservices.MyFirstJava.model.ToDo;
import org.slhejnas.microservices.MyFirstJava.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/all")
    public List<ToDo> getAllToDo(){
        return toDoService.getAllToDo();
    }
    @GetMapping("/{id}")
    public Optional<ToDo> getOneToDo(@PathVariable Long id){
        return toDoService.getOneToDo(id);
    }
    @PutMapping("/{id}")
    public Optional<ToDo> toggleToDo(@PathVariable Long id){
        return toDoService.toggleToDo(id);
    }

}

