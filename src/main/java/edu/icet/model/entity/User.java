package edu.icet.model.entity;

import edu.icet.util.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private UserRole role;
    private String address;
    private String firstName;
    private String lastName;
    private String phoneNo;
}
