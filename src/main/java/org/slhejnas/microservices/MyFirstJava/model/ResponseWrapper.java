package org.slhejnas.microservices.MyFirstJava.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;

@Data
@Entity
public class ResponseWrapper{
    public Boolean wasSuccessful = false;
    public Integer statusCode = 404;
    public String statusMessage = "Not Found";
    public ToDo toDo;

    @Autowired
    public ResponseWrapper(Boolean wasSuccessful, Integer statusCode, String statusMessage, ToDo toDo) {
        this.wasSuccessful = wasSuccessful;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.toDo = toDo;
    }

}
