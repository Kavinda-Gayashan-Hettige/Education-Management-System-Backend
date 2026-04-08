package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String message;

    private String time;
    private LocalDate date;
    private boolean isRead = false;


    public Message() {
        this.date = LocalDate.now();
    }


}