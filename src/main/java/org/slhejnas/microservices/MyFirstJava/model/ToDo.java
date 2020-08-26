package org.slhejnas.microservices.MyFirstJava.model;

import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.time.Instant;


@Data
@Entity
@Table(name = "to_do")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String task_title;
    private Boolean completed = false;
    private Instant created_on = Instant.now();
}
