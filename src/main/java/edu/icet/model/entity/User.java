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
    private String userName;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String address;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private boolean active;
}
