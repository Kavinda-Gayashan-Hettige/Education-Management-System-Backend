package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table
@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parentId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String childName;
}
