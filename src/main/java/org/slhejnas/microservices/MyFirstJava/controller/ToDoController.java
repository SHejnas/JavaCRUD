package org.slhejnas.microservices.MyFirstJava.controller;

import org.slhejnas.microservices.MyFirstJava.model.ResponseWrapper;
import org.slhejnas.microservices.MyFirstJava.model.ToDo;
import org.slhejnas.microservices.MyFirstJava.service.ToDoService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ToDo> getOneToDo(@PathVariable Long id){
        Optional <ToDo> toDo = toDoService.getOneToDo(id);
        if(toDo.isPresent()) {
            return new ResponseEntity<ToDo>(toDo.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<ToDo>(HttpStatus.NOT_FOUND);
            //this is returning 500 not 404, must look into this
        }
    }
    @PutMapping("/{id}")
    public Optional<ToDo> toggleToDo(@PathVariable Long id){
        return toDoService.toggleToDo(id);
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteToDo(@PathVariable Long id){
//        String status = toDoService.deleteToDo(id);
//        if (status.equals("not found")) {
//            return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
//        }else if(status.equals("deleted")){
//            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//        }
//        return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    @DeleteMapping("/{id}")
    public ResponseWrapper deleteToDo(@PathVariable Long id){
        ResponseWrapper response = toDoService.deleteToDo(id);
        return response;
    }
}

