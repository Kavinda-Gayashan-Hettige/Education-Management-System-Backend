package edu.icet.service;

import edu.icet.model.dto.LoginRequestDto;
import edu.icet.model.dto.LoginResponseDto;
import edu.icet.model.dto.RegisterRequestDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto dto);
    void registerUser(RegisterRequestDto dto);
}