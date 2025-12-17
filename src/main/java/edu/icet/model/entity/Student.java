package edu.icet.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String grade;
}
