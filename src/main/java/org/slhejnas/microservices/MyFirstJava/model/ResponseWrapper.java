package org.slhejnas.microservices.MyFirstJava.model;


import lombok.Data;

@Data
public class ResponseWrapper{
    private final boolean wasSuccessful;
    private final Integer statusCode;
    private final String statusMessage;
    private final ToDo toDo;

    public ResponseWrapper(boolean wasSuccessful, Integer statusCode, String statusMessage, ToDo toDo) {
        this.wasSuccessful = wasSuccessful;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.toDo = toDo;
    }

}
