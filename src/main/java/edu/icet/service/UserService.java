package edu.icet.service;

import edu.icet.model.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto registerUser(UserDto userDto);

    boolean loginUser(String userName, String password);

    UserDto getUserById(Integer id);

    void changePassword(Integer id, String newPassword);

    void changeRole(Integer id, String role);

    void deactivateUser(Integer id);

    void activateUser(Integer id);

    void addUser(UserDto user);

    void deleteUser(Integer id);

    void updateUser(UserDto user);

    List<UserDto> getAll();
}
