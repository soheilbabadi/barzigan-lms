package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.person.infra.StudentRepository;
import com.barzigan.www.barziganlms.person.model.Role;
import com.barzigan.www.barziganlms.person.model.Student;
import com.barzigan.www.barziganlms.person.model.StudentDto;
import com.barzigan.www.barziganlms.person.model.StudentUpdateDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static com.barzigan.www.barziganlms.utils.RandomString.gerRandomString;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAll() {

        var list = studentRepository.findAll();
        var result = new ArrayList<StudentDto>();
        for (var item : list) {
            var dto = new StudentDto();
            BeanUtils.copyProperties(item, dto);
            result.add(dto);
        }
        return result;
    }

    @Override
    public StudentDto findById(long id) {

        var student = studentRepository.findById(id);
        var dto = new StudentDto();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }

    @Override
    public StudentDto findByEmail(String email) {

        var student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new NullPointerException("Student not found"));
        var dto = new StudentDto();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }

    @Override
    public StudentDto findByNationalCode(String nationalCode) {

        var student = studentRepository.findByNationalCode(nationalCode)
                .orElseThrow(() -> new NullPointerException("Student not found"));
        var dto = new StudentDto();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }

    @Override
    public StudentDto findByPhoneNumber(String phoneNumber) {

        var student = studentRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new NullPointerException("Student not found"));
        var dto = new StudentDto();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }


    @Override
    public StudentDto update(StudentUpdateDto dto) {

        var student = studentRepository.findById(dto.getId())
                .orElseThrow(() -> new NullPointerException("Student not found"));


        var existStd = studentRepository.findByNationalCode(dto.getNationalCode());
        if (existStd.isPresent() && existStd.get().getId() != dto.getId())
            throw new RuntimeException("National code is already exists");

        existStd = studentRepository.findByEmail(dto.getEmail());
        if (existStd.isPresent() && existStd.get().getId() != dto.getId())
            throw new RuntimeException("Email is already exists");

        existStd = studentRepository.findByPhoneNumber(dto.getPhoneNumber());
        if (existStd.isPresent() && existStd.get().getId() != dto.getId())
            throw new RuntimeException("Phone number is already exists");

        BeanUtils.copyProperties(dto, student);
        studentRepository.save(student);
        return findByEmail(dto.getEmail());
    }

    @Override
    public void create(StudentDto studentDto) {

        var student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        student.setRegisterOn(LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()));
        student.setLastLoginOn(student.getRegisterOn());
        student.setVerified(false);
        student.setAccountNonExpired(true);
        student.setRole(Role.STUDENT);
        student.setAccountNonLocked(true);
        student.setEnabled(true);
        student.setUsername(gerRandomString(50));
        student.setCredentialsNonExpired(true);

        studentRepository.save(student);

    }

    @Override
    public void delete(String username) {

        var student = studentRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }

    @Override
    public boolean isUserExists(StudentDto studentDto) {
        return studentRepository.findByNationalCode(studentDto.getNationalCode()).isPresent() || studentRepository.findByEmail(studentDto.getEmail()).isPresent() || studentRepository.findByPhoneNumber(studentDto.getPhoneNumber()).isPresent();
    }
}
