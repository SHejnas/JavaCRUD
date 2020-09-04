package org.slhejnas.microservices.MyFirstJava.controller;

import org.slhejnas.microservices.MyFirstJava.exception.ToDoNotFoundException;
import org.slhejnas.microservices.MyFirstJava.model.ToDoResponse;
import org.slhejnas.microservices.MyFirstJava.model.ToDo;
import org.slhejnas.microservices.MyFirstJava.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
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
    public ResponseEntity<ToDoResponse> createToDo(@RequestBody ToDo toDo){
        try {
            ToDo toDo1 = toDoService.insertToDo(toDo);
            final ToDoResponse toDoResponse = new ToDoResponse(true, 200, "retrieved ToDo Successfully", toDo1, null, null);
            return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.OK);
        } catch (ToDoNotFoundException tdnfe){
            final ToDoResponse toDoResponse = new ToDoResponse(false, 404, "No ToDos Found", null, null,tdnfe);
            return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<ToDoResponse> getAllToDo(){
        try {
            List<ToDo> toDoList = toDoService.getAllToDo();
            final ToDoResponse toDoResponse = new ToDoResponse(true, 200, "retrieved ToDo Successfully", null, toDoList,null);
            return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.OK);
        }catch(ToDoNotFoundException tdnfe) {

            final ToDoResponse toDoResponse = new ToDoResponse(false, 404, "No ToDos Found", null, null, tdnfe);
            return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ToDoResponse> getOneToDo(@PathVariable Long id){
        try {
            ToDo toDo = toDoService.getOneToDo(id);
            final ToDoResponse toDoResponse = new ToDoResponse(true, 200, "retrieved ToDo Successfully", toDo, null, null);
            return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.OK);
        }catch(ToDoNotFoundException tdnfe){
            final ToDoResponse toDoResponse = new ToDoResponse(false, 404, "No ToDos Found", null, null, tdnfe);
            return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoResponse> toggleToDo(@PathVariable Long id) {
        try {
            ToDo toDo = toDoService.toggleToDo(id);
            final ToDoResponse toDoResponse = new ToDoResponse(true, 200, "Updated Successfully", toDo, null, null);
            return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.OK);
        }catch (ToDoNotFoundException tdnfe){
            final ToDoResponse toDoResponse = new ToDoResponse(false, 404, "No ToDos Found", null, null, tdnfe);
            return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToDoResponse> deleteToDo(@PathVariable Long id){
        try {
            toDoService.deleteToDo(id);
            final ToDoResponse toDoResponse = new ToDoResponse(true, 200, "Deleted Successfully",null, null, null);
            return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.OK);
        }catch (ToDoNotFoundException tdnfe){
            final ToDoResponse toDoResponse = new ToDoResponse(false, 404, "No ToDos Found",null, null, tdnfe);
            return  new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.NOT_FOUND);
        }

    }
}

