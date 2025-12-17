package edu.icet.controller;

import edu.icet.model.dto.ParentDto;
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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudent(@RequestBody StudentDto student) {
        service.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDto> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDto getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }
}
