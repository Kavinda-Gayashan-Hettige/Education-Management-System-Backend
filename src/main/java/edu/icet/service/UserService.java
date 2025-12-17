package edu.icet.service;

import edu.icet.model.dto.UserDto;

import java.util.List;


public interface UserService {
    UserDto registerUser(UserDto userDto);


    boolean loginUser(String userName, String password);

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();
}
