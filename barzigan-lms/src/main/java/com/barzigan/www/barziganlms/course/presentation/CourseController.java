﻿package com.barzigan.www.barziganlms.course.presentation;

import com.barzigan.www.barziganlms.course.application.CourseService;
import com.barzigan.www.barziganlms.course.model.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CourseDto courseDto) {
        courseService.createCourse(courseDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CourseDto courseDto) {
        courseService.updateCourse(courseDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> get(@PathVariable long id) {
        var courseDto = courseService.getCourse(id);
        return ResponseEntity.ok(courseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<CourseDto> getAll() {
        var courseDtoList = courseService.getAll();
        return ResponseEntity.ok().build();
    }
}
