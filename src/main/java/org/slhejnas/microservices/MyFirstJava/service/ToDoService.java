package org.slhejnas.microservices.MyFirstJava.service;

import lombok.extern.slf4j.Slf4j;
import org.slhejnas.microservices.MyFirstJava.exception.ToDoNotFoundException;
import org.slhejnas.microservices.MyFirstJava.model.ToDoResponse;
import org.slhejnas.microservices.MyFirstJava.model.ToDo;
import org.slhejnas.microservices.MyFirstJava.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo insertToDo(ToDo toDo) throws ToDoNotFoundException{
            return toDoRepository.save(toDo);
    }

    public List<ToDo> getAllToDo() throws ToDoNotFoundException {
        List<ToDo> toDoList = toDoRepository.findAll();
        if (!toDoList.isEmpty()){
            return toDoList;
        }else{
            throw new ToDoNotFoundException();
        }
    }

    public ToDo getOneToDo(Long id) throws ToDoNotFoundException {
        Optional<ToDo> toDoOptional =  toDoRepository.findById(id);
        if (toDoOptional.isPresent()) {
            return toDoOptional.get();
        } else {
            throw new ToDoNotFoundException();
        }
    }

    public ToDo toggleToDo (Long id) throws ToDoNotFoundException{

        Optional<ToDo> toDoOptional = toDoRepository.findById(id);
        if (toDoOptional.isPresent()) {

            ToDo toDo = toDoOptional.get();
            toDo.setCompleted(!toDo.getCompleted());
            toDoRepository.save(toDo);
            return  toDo;
        }else {
            throw new ToDoNotFoundException();
        }
    }
    public void deleteToDo (Long id) throws ToDoNotFoundException {
        Optional<ToDo> toDoOptional = toDoRepository.findById(id);
        if (toDoOptional.isPresent()) {
            toDoRepository.deleteById(id);
        } else {
            throw new ToDoNotFoundException();
        }
    }

}
