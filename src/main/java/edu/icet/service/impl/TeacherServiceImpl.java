package edu.icet.service.impl;

import edu.icet.model.dto.TeacherDto;
import edu.icet.model.entity.Teacher;
import edu.icet.repository.TeacherRepository;
import edu.icet.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    final TeacherRepository repository;
    final ModelMapper mapper;
    @Override
    public void addTeacher(TeacherDto teacher) {
        repository.save(mapper.map(teacher, Teacher.class));
    }

    @Override
    public void deleteTeacher(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateTeacher(TeacherDto teacher) {
        repository.save(mapper.map(teacher, Teacher.class));
    }

    @Override
    public List<TeacherDto> getAll() {
        List<TeacherDto> teacherList = new ArrayList<>();
        List<Teacher> all = repository.findAll();

        all.forEach(teacherEntity -> {
            teacherList.add(mapper.map(teacherEntity, TeacherDto.class));
        });

        return teacherList;
    }
}
