package edu.icet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.icet.model.dto.CourseDto;
import edu.icet.model.entity.Course;
import edu.icet.service.CourseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody CourseDto course) {
       return courseService.createCourse(course);
    }

    @GetMapping("/get-all")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();

    }

    @GetMapping("/get/{id}")
    public void getCourseById(@PathVariable Long id) {
        courseService.getCourseById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
