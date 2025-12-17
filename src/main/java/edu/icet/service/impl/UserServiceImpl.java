package edu.icet.service.impl;

import edu.icet.model.dto.UserDto;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.service.UserService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


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


}
