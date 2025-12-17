package edu.icet.service.impl;

import edu.icet.model.dto.ParentDto;
import edu.icet.model.dto.StudentDto;
import edu.icet.model.dto.TeacherDto;
import edu.icet.model.entity.Parent;
import edu.icet.model.entity.Student;
import edu.icet.model.entity.Teacher;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentList = new ArrayList<>();
        List<Student> all = repository.findAll();

        all.forEach(studentEntity -> {
            studentList.add(mapper.map(studentEntity, StudentDto.class));
        });

        return studentList;
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        return mapper.map(student, StudentDto.class);
    }


}
