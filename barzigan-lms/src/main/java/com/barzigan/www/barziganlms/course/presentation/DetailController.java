package com.barzigan.www.barziganlms.course.presentation;

import com.barzigan.www.barziganlms.course.application.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RequestMapping("/api/v1/course")
@RestController
@RequiredArgsConstructor
public class DetailController {

    private final DetailService detailService;

    @GetMapping
    Public ResponseEntity<CourseDto> getAll(){
        var courseDtoList = detailService.getAll();
        return ResponseEntity.ok().build();
    }
}
