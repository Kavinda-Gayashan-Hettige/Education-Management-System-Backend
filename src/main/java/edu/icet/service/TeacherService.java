package edu.icet.service;

import edu.icet.model.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    void addTeacher(TeacherDto teacher);

    void deleteTeacher(Integer id);

    void updateTeacher(TeacherDto teacher);

    List<TeacherDto> getAll();
}
