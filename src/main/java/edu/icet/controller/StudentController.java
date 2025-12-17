package edu.icet.controller;

import edu.icet.model.dto.StudentDto;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    final StudentService service;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody StudentDto student) {
        service.addStudent(student);
        System.out.println(student);
    }

}
