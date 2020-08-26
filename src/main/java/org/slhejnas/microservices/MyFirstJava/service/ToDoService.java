package org.slhejnas.microservices.MyFirstJava.service;

import org.slhejnas.microservices.MyFirstJava.model.ToDo;
import org.slhejnas.microservices.MyFirstJava.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;
    @Autowired
    public ToDoService (ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }
    public ToDo insertToDo(ToDo toDo){
        return toDoRepository.save(toDo);
    }
    public List<ToDo> getAllToDo(){
        return toDoRepository.findAll();
    }
    public Optional<ToDo> getOneToDo(Long id){
        return toDoRepository.findById(id);
    }
    public Optional<ToDo> toggleToDo(Long id){
        //getters and setters by lombok?
        Optional<ToDo> toDo = toDoRepository.findById(id);
        toDo.completed = !toDo.completed;
        toDoRepository.put()


    }
}
