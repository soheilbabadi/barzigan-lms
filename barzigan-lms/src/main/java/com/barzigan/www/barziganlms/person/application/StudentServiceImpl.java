package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.person.infra.StudentRepository;
import com.barzigan.www.barziganlms.person.model.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findAll() {

        var list = studentRepository.findAll();

        return null;}

}
