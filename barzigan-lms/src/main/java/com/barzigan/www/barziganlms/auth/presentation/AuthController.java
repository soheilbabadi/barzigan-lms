package com.barzigan.www.barziganlms.auth.presentation;

import com.barzigan.www.barziganlms.auth.model.AuthenticationResponse;
import com.barzigan.www.barziganlms.auth.model.RegisterRequestDto;
import com.barzigan.www.barziganlms.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequestDto dto){

        return  ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody RegisterRequestDto dto){

        return  ResponseEntity.ok(authService.authenticate(dto));
    }

}