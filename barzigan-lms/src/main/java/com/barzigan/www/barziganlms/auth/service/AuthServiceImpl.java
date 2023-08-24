package com.barzigan.www.barziganlms.auth.service;

import com.barzigan.www.barziganlms.auth.model.AuthenticationResponse;
import com.barzigan.www.barziganlms.auth.model.RegisterRequestDto;
import com.barzigan.www.barziganlms.person.application.OtpService;
import com.barzigan.www.barziganlms.person.infra.StudentRepository;
import com.barzigan.www.barziganlms.person.model.Role;
import com.barzigan.www.barziganlms.person.model.Student;
import com.barzigan.www.barziganlms.security.JwtService;
import com.barzigan.www.barziganlms.utils.RandomString;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private OtpService otpService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(RegisterRequestDto dto) {

        String username = RandomString.gerRandomString(50);

        var person = Student.builder().firstName("")

                .accountNonExpired(true)
                .accountNonLocked(true)
                .address("")
                .email(dto.getEmail())
                .credentialsNonExpired(true)
                .enabled(true)
                .password(passwordEncoder.encode(dto.getPassword()))
                .birthDate(LocalDate.now().minusYears(18))
                .registerOn(LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()))
                .lastLoginOn(LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()))
                .role(Role.STUDENT)
                .username(username)
                .lastName("")
                .phoneNumber("")
                .nationalCode("")
                .postalCode("")
                .city("")
                .province("")
                .role(Role.STUDENT)
                .verified(false)
                .nationalCode("")
                .build();

        studentRepository.save(person);

        otpService.save(person.getEmail());

        return generateResponse(person);
    }

    @Override
    public AuthenticationResponse authenticate( RegisterRequestDto dto) {
        var person = studentRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("user not found"));

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(person.getUsername(), dto.getPassword()));
        person.setLastLoginOn(LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()));
        studentRepository.save(person);
        return generateResponse(person);

    }

    @Override
    public String extractUsername(String token) {
      return jwtService.extractUsername(token);
    }

    private AuthenticationResponse generateResponse(Student person) {

        var jwtToken = jwtService.generateToken(person);
        var authResponse= new AuthenticationResponse();
        BeanUtils.copyProperties(person, authResponse);
        authResponse.setToken(jwtToken);

        return authResponse;
    }



}
