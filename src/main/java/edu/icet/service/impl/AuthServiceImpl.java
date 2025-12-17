package edu.icet.service.impl;

import edu.icet.model.dto.LoginRequestDto;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User login(LoginRequestDto dto) {

        User user = userRepository.findByUserName(dto.getUserName())
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));

        // account active check
        if (!user.isActive()) {
            throw new BadCredentialsException("User account is deactivated");
        }

        // password check
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        return user;
    }
}
