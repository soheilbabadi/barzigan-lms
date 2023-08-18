package com.barzigan.www.barziganlms.security;

import com.barzigan.www.barziganlms.person.application.StudentService;
import com.barzigan.www.barziganlms.person.model.LoginDto;
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
    private StudentService studentService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody LoginDto dto){

        return  ResponseEntity.ok(studentService.findByUsernameAndPassword(dto));
    }


}