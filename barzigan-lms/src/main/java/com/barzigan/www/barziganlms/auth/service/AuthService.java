package com.barzigan.www.barziganlms.auth.service;

import com.barzigan.www.barziganlms.auth.model.AuthenticationResponse;
import com.barzigan.www.barziganlms.auth.model.RegisterRequestDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

public interface AuthService {
    AuthenticationResponse register( RegisterRequestDto dto);

    AuthenticationResponse authenticate(RegisterRequestDto dto);
    String extractUsername(String token);
}
