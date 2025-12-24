package edu.icet.model.entity;

import edu.icet.util.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true) 
    private String userName;
    
    private String password; 
    private String firstName;
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    private UserRole role; 
    
    private boolean active = true; 
}