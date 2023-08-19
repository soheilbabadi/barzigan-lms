package com.barzigan.www.barziganlms.person.presentation;


import com.barzigan.www.barziganlms.person.application.OtpService;
import com.barzigan.www.barziganlms.person.model.dto.OtpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;


    @PostMapping
    public ResponseEntity<Boolean> validateOtp(OtpRequestDto dto) {
        boolean result = otpService.isOtpValid(dto);
        if (result)
            return ResponseEntity.ok(true);
        else
            return ResponseEntity.badRequest().body(false);

    }


}
