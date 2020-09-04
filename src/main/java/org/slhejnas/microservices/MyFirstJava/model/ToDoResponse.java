package org.slhejnas.microservices.MyFirstJava.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToDoResponse {
    private boolean wasSuccessful;
    private Integer statusCode;
    private String statusMessage;
    private ToDo toDo;
    private List<ToDo> toDoList;
    private Exception ToDoNotFoundException;

//    public ResponseWrapper(boolean wasSuccessful, Integer statusCode, String statusMessage ) {
//        this.wasSuccessful = wasSuccessful;
//        this.statusCode = statusCode;
//        this.statusMessage = statusMessage;
//        this.toDo = toDo;
//    }

}
