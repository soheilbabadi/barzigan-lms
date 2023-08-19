package com.barzigan.www.barziganlms.person.presentation;


import com.barzigan.www.barziganlms.person.application.OtpService;
import com.barzigan.www.barziganlms.person.model.dto.OtpDto;
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

    @PostMapping("/find")
    public ResponseEntity<OtpDto> findOtp(OtpDto dto) {
        return ResponseEntity.ok(otpService.findOtp(dto));
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(String email) {
        otpService.save(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete() {
        otpService.delete();
        return ResponseEntity.ok().build();
    }


}
