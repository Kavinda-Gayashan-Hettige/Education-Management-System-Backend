package edu.icet.controller;

import edu.icet.model.dto.LoginRequestDto;
import edu.icet.model.dto.LoginResponseDto;
import edu.icet.model.dto.RegisterRequestDto;
import edu.icet.model.dto.UserDto;
import edu.icet.service.AuthService;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize; 
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") 
@RequiredArgsConstructor
@CrossOrigin 
public class UserController {

    private final AuthService authService; 
    private final UserService userService;
   
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequestDto dto) {
        authService.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

   
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) {
        LoginResponseDto response = authService.login(dto); 
        return ResponseEntity.ok(response); 
    }


    @GetMapping("/admin/data")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> getAdminData() {
        return ResponseEntity.ok("Welcome, ADMIN! This is secured data.");
    }


    @GetMapping("/teacher/data")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public ResponseEntity<String> getTeacherData() {
        return ResponseEntity.ok("Welcome, Teacher/Admin! This is teacher data.");
    }


    @GetMapping("/student/data")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT', 'PARENT')")
    public ResponseEntity<String> getStudentData() {
        return ResponseEntity.ok("Welcome, Student! This is student data.");
    }


     @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserDto user) {
        userService.addUser(user);
      
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @PutMapping("/update-user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody UserDto user){
        userService.updateUser(user);
    }

    @GetMapping("/get-all")
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/id/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/id/{id}/password")
    public void changePassword(@PathVariable Integer id,
                               @RequestParam String newPassword) {
        userService.changePassword(id, newPassword);
    }

    @PutMapping("/id/{id}/role")
    public void changeRole(@PathVariable Integer id,
                           @RequestParam String role) {
        userService.changeRole(id, role);
    }

     @PutMapping("/id/{id}/deactivate")
    public void deactivateUser(@PathVariable Integer id) {
        userService.deactivateUser(id);
    }

     @PutMapping("/id/{id}/activate")
    public void activateUser(@PathVariable Integer id) {
        userService.activateUser(id);
    }


}

// users/add,/delete/{id},/update-user,/get-all,/{id},/{id}/password,/{id}/role,/{id}/deactivate,/{id}/activate