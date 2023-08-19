package com.barzigan.www.barziganlms.person.presentation;


import com.barzigan.www.barziganlms.person.application.StudentService;
import com.barzigan.www.barziganlms.person.model.StudentDto;
import com.barzigan.www.barziganlms.person.model.StudentUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PutMapping
    public ResponseEntity<StudentDto> update(@RequestBody StudentUpdateDto dto) {

        return ResponseEntity.ok(studentService.update(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String username) {
        studentService.delete(username);
        return ResponseEntity.ok().build();
    }
}
