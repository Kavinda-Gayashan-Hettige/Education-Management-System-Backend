package edu.icet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.icet.model.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

   
} 
