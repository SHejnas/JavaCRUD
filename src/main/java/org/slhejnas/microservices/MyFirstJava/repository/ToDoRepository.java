package org.slhejnas.microservices.MyFirstJava.repository;


import org.slhejnas.microservices.MyFirstJava.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository <ToDo, Long> {

}
