package com.barzigan.www.barziganlms.auth.service;

import com.barzigan.www.barziganlms.auth.model.AuthenticationResponse;
import com.barzigan.www.barziganlms.auth.model.RegisterRequestDto;
import com.barzigan.www.barziganlms.person.infra.StudentRepository;
import com.barzigan.www.barziganlms.person.model.Role;
import com.barzigan.www.barziganlms.person.model.Student;
import com.barzigan.www.barziganlms.security.JwtService;
import com.barzigan.www.barziganlms.utils.RandomString;
import lombok.RequiredArgsConstructor;
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
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequestDto dto) {

        String username = passwordEncoder.encode(dto.getEmail());

        var person = Student.builder().firstName("").registerOn(LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()))
                .lastLoginOn(LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .address("")
                .email(dto.getEmail())
                .credentialsNonExpired(true)
                .enabled(true)
                .password(passwordEncoder.encode(dto.getPassword()))
                .birthDate(LocalDate.now().minusYears(18))
                .username(dto.getEmail())
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

        return generateResponse(person);
    }

    @Override
    public AuthenticationResponse authenticate(RegisterRequestDto dto) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        var person = studentRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("user not found"));



        person.setLastLoginOn(LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()));
        studentRepository.save(person);
        return generateResponse(person);

    }

    private AuthenticationResponse generateResponse(Student person) {
        var jwtToken = jwtService.generateToken(person);
        return AuthenticationResponse.builder().token(jwtToken)
                .email(person.getEmail())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .birthDate(person.getBirthDate())
                .registerDate(person.getRegisterOn())
                .role(person.getRole().name())
                .lastLoginOn(person.getLastLoginOn())
                .verified(person.isVerified())
                .accountNonExpired(person.isAccountNonExpired())
                .accountNonLocked(person.isAccountNonLocked())
                .credentialsNonExpired(person.isCredentialsNonExpired())
                .enabled(person.isEnabled())
                .city(person.getCity())
                .province(person.getProvince())
                .address(person.getAddress())
                .phoneNumber(person.getPhoneNumber())
                .postalCode(person.getPostalCode())
                .nationalCode(person.getNationalCode())
                .build();
    }

}
