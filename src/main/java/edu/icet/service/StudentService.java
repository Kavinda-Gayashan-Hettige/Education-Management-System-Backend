package edu.icet.service;

import edu.icet.model.entity.Student;

import java.util.List;

public interface StudentService {

    Student getStudentDetails(Long id);

    Student saveStudent(Student student);

    List<Student> getAllStudents();
}
