package edu.icet.controller;

import edu.icet.model.dto.TeacherDto;
import edu.icet.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    final TeacherService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTeacher(@RequestBody TeacherDto teacher) {
        service.addTeacher(teacher);
        System.out.println(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable  Integer id){
        service.deleteTeacher(id);
    }
}
