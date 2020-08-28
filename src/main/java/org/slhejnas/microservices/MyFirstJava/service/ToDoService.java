package org.slhejnas.microservices.MyFirstJava.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slhejnas.microservices.MyFirstJava.model.ToDo;
import org.slhejnas.microservices.MyFirstJava.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
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
        Optional <ToDo> toDoOptional = toDoRepository.findById(id);
        log.debug("returning: {}", toDoOptional.orElseGet(() -> null));
        return toDoOptional;
    }

    public Optional<ToDo> toggleToDo(Long id){

        Optional<ToDo> toDoOptional = toDoRepository.findById(id);
        if(toDoOptional.isPresent()) {

            ToDo toDo = toDoOptional.get();
            toDo.setCompleted(!toDo.getCompleted());
            toDoRepository.save(toDo);
        }
        return toDoOptional;
    }
    public String deleteToDo(Long id){
        Optional<ToDo> toDoOptional = toDoRepository.findById(id);
        if(toDoOptional.isPresent()) {
            toDoRepository.deleteById(id);
            return "deleted";
        }else {
            return "not found";
        }
    }
}
