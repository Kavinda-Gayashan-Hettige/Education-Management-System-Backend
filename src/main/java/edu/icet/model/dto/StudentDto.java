package edu.icet.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StudentDto {
    private Long studentId;
    private UserDto user;
    private String grade;
}
