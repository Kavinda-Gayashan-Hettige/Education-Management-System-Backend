package edu.icet.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class ParentDto {
    private Integer parentId;
    private UserDto user;
    private String childName;
}
