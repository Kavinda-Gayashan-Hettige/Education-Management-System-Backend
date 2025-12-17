package edu.icet.controller;

import edu.icet.model.dto.StudentDto;
import edu.icet.model.dto.TeacherDto;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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
