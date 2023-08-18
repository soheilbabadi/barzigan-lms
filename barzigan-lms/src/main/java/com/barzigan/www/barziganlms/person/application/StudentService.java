package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.person.model.LoginDto;
import com.barzigan.www.barziganlms.person.model.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();

    StudentDto findById(long id);

    StudentDto findByEmail(String email);

    StudentDto findByNationalCode(String nationalCode);

    StudentDto findByPhoneNumber(String phoneNumber);

    StudentDto findByUsernameAndPassword(LoginDto dto);

    void update(StudentDto studentDto);

    void create(StudentDto studentDto);

    void delete(long id);

    boolean isUserExists(StudentDto studentDto);
}