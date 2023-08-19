package com.barzigan.www.barziganlms.utils;


import com.barzigan.www.barziganlms.person.model.Student;
import com.barzigan.www.barziganlms.security.JwtService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public  class TokenUtils {
    private final JwtService jwtService;

    public String extractUsername(String token) {
        return jwtService.extractUsername(token);

    }
    public boolean isTokenValid(String token, Student student){
        return jwtService.isTokenValid(token,student);
    }

}
