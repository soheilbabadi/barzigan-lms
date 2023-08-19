package com.barzigan.www.barziganlms.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
    @GetMapping
    public ResponseEntity<ResponseDemo> get() {
        var currentRequestAttributes = RequestContextHolder.currentRequestAttributes();
        var result = currentRequestAttributes.getAttribute("token", ServletRequestAttributes.SCOPE_REQUEST).toString();

        ResponseDemo responseDemo = ResponseDemo.builder()
                .token(result)
                .username("username")
                .build();

        System.out.print(responseDemo.getToken());
        return new ResponseEntity<>(responseDemo, HttpStatus.OK);
    }


}