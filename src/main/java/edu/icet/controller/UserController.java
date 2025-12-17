package edu.icet.controller;

import edu.icet.model.dto.UserDto;
import edu.icet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.registerUser(userDto);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDto userDto) {
        boolean success = userService.loginUser(userDto.getUserName(), userDto.getPassword());
        if (success) return ResponseEntity.ok("Login successful");
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
