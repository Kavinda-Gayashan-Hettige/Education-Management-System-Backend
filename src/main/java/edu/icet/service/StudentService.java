package edu.icet.service;

import edu.icet.model.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void addStudent(StudentDto student);

    void updateStudent(StudentDto student);

    void deleteStudent(Integer id);

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Integer id);
}
