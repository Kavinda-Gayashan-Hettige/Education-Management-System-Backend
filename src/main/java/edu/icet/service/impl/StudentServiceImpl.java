package edu.icet.service.impl;

import edu.icet.model.dto.StudentDto;
import edu.icet.model.entity.Student;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    StudentRepository repository;
    ModelMapper mapper;
    @Override
    public void addStudent(StudentDto student) {
        repository.save(mapper.map(student, Student.class));
    }

    @Override
    public void updateStudent(StudentDto student) {
        repository.save(mapper.map(student, Student.class));
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }


}
