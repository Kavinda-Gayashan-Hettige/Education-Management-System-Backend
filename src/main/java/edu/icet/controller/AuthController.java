package edu.icet.controller;

import edu.icet.model.dto.LoginRequestDto;
import edu.icet.model.dto.LoginResponseDto;
import edu.icet.model.entity.User;
import edu.icet.security.JwtUtil;
import edu.icet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) {

        User user = authService.login(dto);

        String token = jwtUtil.generateToken(
                user.getUserName(),
                user.getRole().name()
        );

        return new LoginResponseDto(token, user.getRole().name());
    }
}
