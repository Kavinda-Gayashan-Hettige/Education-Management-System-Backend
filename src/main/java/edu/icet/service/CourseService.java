package edu.icet.service;

import java.util.List;

import edu.icet.model.dto.CourseDto;
import edu.icet.model.entity.Course;

public interface CourseService {

    Course createCourse(CourseDto course);

    List<CourseDto> getAllCourses();

    void getCourseById(Long id);

    void deleteCourse(Long id);
  
} 
    

