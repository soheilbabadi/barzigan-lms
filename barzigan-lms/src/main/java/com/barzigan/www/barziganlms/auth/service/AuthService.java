package com.barzigan.www.barziganlms.auth.service;

import com.barzigan.www.barziganlms.auth.model.AuthenticationResponse;
import com.barzigan.www.barziganlms.auth.model.RegisterRequestDto;

public interface AuthService {
    AuthenticationResponse register(RegisterRequestDto dto);

    AuthenticationResponse authenticate(RegisterRequestDto dto);
}
