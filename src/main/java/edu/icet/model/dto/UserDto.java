package edu.icet.model.dto;

import edu.icet.util.UserRole;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private UserRole role;
    private String address;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private boolean active;
}
