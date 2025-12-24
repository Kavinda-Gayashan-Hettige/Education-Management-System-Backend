package edu.icet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.icet.model.dto.CourseDto;
import edu.icet.model.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<CourseDto> findByName(String name);

    
} 
