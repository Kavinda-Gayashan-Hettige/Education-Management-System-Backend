package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Entity
@Table
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminID;
    private String name;
}
