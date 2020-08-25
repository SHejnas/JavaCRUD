package org.slhejnas.microservices.MyFirstJava.service;

import org.slhejnas.microservices.MyFirstJava.model.ToDo;
import org.slhejnas.microservices.MyFirstJava.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
