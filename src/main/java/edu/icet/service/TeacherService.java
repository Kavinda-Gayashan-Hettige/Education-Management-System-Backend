package edu.icet.service;

import edu.icet.model.dto.TeacherDto;

public interface TeacherService {
    void addTeacher(TeacherDto teacher);

    void deleteTeacher(Integer id);

    void updateTeacher(TeacherDto teacher);
}
