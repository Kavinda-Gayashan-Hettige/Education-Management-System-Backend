package edu.icet.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TeacherDto {
private Integer teacherID;
private String name;
private UserDto user;
private String course;
}
