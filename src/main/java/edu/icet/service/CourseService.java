package edu.icet.service;

import java.util.Optional;
import java.util.List;
import edu.icet.model.dto.CourseDto;

public interface CourseService {

     CourseDto createCourse(CourseDto dto);
     List<CourseDto> getAllCourses();
     Optional<CourseDto> getCourseById(Long id);
     void deleteCourse(Long id);
} 
    

