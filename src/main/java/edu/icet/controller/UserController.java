package edu.icet.controller;

import edu.icet.model.dto.LoginRequestDto;
import edu.icet.model.dto.LoginResponseDto;
import edu.icet.model.dto.RegisterRequestDto;
import edu.icet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize; // Role-based security සඳහා
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") 
@RequiredArgsConstructor
@CrossOrigin 
public class UserController {

    private final AuthService authService; 

    // 🚨 Public Endpoint: Token අවශ්‍ය නොවේ
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequestDto dto) {
        authService.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    // 🚨 Public Endpoint: Token අවශ්‍ය නොවේ
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) {
        LoginResponseDto response = authService.login(dto); 
        return ResponseEntity.ok(response); 
    }

    // 🚨 Secured Endpoint: ADMIN ට පමණක් අවසර
    @GetMapping("/admin/data")
    @PreAuthorize("hasRole('ADMIN')") 
    public ResponseEntity<String> getAdminData() {
        return ResponseEntity.ok("Welcome, ADMIN! This is secured data.");
    }
    
    // 🚨 Secured Endpoint: TEACHER සහ ADMIN ට අවසර
    @GetMapping("/teacher/data")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')") 
    public ResponseEntity<String> getTeacherData() {
        return ResponseEntity.ok("Welcome, Teacher/Admin! This is teacher data.");
    }
    
    // 🚨 Secured Endpoint: STUDENT, TEACHER, ADMIN ට අවසර
    @GetMapping("/student/data")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER', 'STUDENT')") 
    public ResponseEntity<String> getStudentData() {
        return ResponseEntity.ok("Welcome, Student! This is student data.");
    }
}