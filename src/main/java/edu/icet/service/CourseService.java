package edu.icet.service;

import java.util.List;

import edu.icet.model.dto.CourseDto;

public interface CourseService {

    void createCourse(CourseDto course);

    List<CourseDto> getAllCourses();

    void getCourseById(Long id);

    void deleteCourse(Long id);
  
} 
    

