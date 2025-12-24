// RegisterRequestDto.java
package edu.icet.model.dto;
import edu.icet.util.UserRole;
import lombok.Data;

@Data
public class RegisterRequestDto {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole role; // Register කරන විට Role එක දෙනවා
}