package edu.icet.service.impl;

import edu.icet.model.dto.UserDto;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.service.UserService;

import edu.icet.util.UserRole;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;


    @Override
    public UserDto registerUser(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        user.setActive(true); // default active
        User savedUser = repository.save(user);
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public boolean loginUser(String userName, String password) {
        return repository
                .findByUserName(userName)
                .filter(u -> u.getPassword().equals(password))
                .filter(User::isActive)
                .isPresent();
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Integer id, UserDto userDto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNo(userDto.getPhoneNo());

        User updatedUser = repository.save(user);
        return mapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void changePassword(Integer id, String newPassword) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(newPassword);
        repository.save(user);
    }

    @Override
    public void changeRole(Integer id, String role) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(UserRole.valueOf(role));
        repository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        repository.deleteById(id);
    }

    @Override
    public void deactivateUser(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(false);
        repository.save(user);
    }



}
