package edu.icet.service.impl;

import edu.icet.model.dto.LoginRequestDto;
import edu.icet.model.dto.LoginResponseDto;
import edu.icet.model.dto.RegisterRequestDto;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.service.AuthService;
import edu.icet.security.JwtUtil; 
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil; 
    
    @Override
    public void registerUser(RegisterRequestDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setRole(dto.getRole());
        user.setActive(true);
        
       
        user.setPassword(passwordEncoder.encode(dto.getPassword())); 
        
        userRepository.save(user);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {

        User user = userRepository.findByUserName(dto.getUserName())
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));

        if (!user.isActive()) {
            throw new BadCredentialsException("User account is deactivated");
        }

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
        
        String jwtToken = jwtUtil.generateToken(user);
        
        return new LoginResponseDto(
            jwtToken, 
            user.getRole().name(),
            user.getUserName() 
        );
    }
}