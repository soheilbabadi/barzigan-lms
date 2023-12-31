package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.person.model.dto.StudentDto;
import com.barzigan.www.barziganlms.person.model.dto.StudentUpdateDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();

    StudentDto findById(long id);

    StudentDto findByEmail(String email);

    StudentDto findByNationalCode(String nationalCode);

    StudentDto findByPhoneNumber(String phoneNumber);

    String update(StudentUpdateDto studentDto);

    void create(StudentDto studentDto);

    void delete(String username);

    boolean isUserExists(StudentDto studentDto);
}
