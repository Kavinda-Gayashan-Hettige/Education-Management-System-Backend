package edu.icet.service;

import edu.icet.model.dto.LoginRequestDto;
import edu.icet.model.entity.User;

public interface AuthService {
    User login(LoginRequestDto dto);
}
