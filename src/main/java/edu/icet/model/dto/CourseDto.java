package edu.icet.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Long id; 
    private String name;
    private String description;
    private int durationMonths;
    private double fee;
}