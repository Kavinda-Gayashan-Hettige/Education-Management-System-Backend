package edu.icet.service;

import edu.icet.model.dto.StudentDto;

public interface StudentService {
    void addStudent(StudentDto student);

    void updateStudent(StudentDto student);
}
