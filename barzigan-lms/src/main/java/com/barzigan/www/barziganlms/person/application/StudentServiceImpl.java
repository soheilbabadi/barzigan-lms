package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.person.infra.StudentRepository;
import com.barzigan.www.barziganlms.person.model.Student;
import com.barzigan.www.barziganlms.person.model.StudentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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

    public StudentDto findById(long id) {

        var student = studentRepository.findById(id);
        var dto = new StudentDto();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }

    public StudentDto findByEmail(String email) {

        var student = studentRepository.findByEmail(email);
        var dto = new StudentDto();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }

    public StudentDto findByNationalCode(String nationalCode) {

        var student = studentRepository.findByNationalCode(nationalCode);
        var dto = new StudentDto();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }

    public StudentDto findByPhoneNumber(String phoneNumber) {

        var student = studentRepository.findByPhoneNumber(phoneNumber);
        var dto = new StudentDto();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }

    public StudentDto findByUsernameAndPassword(String username, String password) {

        var student = studentRepository.findByNationalCodeOrEmailAndPassword(username, username, password);
        var dto = new StudentDto();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }

    public void update(StudentDto studentDto) {

        var student = studentRepository.findById(studentDto.getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        BeanUtils.copyProperties(studentDto, student);

        var p = studentRepository.save(student);

    }


    public void create(StudentDto studentDto) {

        var student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        student.setRegisterDate(LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()));
        var p = studentRepository.save(student);
    }

    public void delete(long id) {

        var student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }

}
