package org.slhejnas.microservices.MyFirstJava.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "to_do")
public class ToDo {
    @Id
 private Long id;

}
