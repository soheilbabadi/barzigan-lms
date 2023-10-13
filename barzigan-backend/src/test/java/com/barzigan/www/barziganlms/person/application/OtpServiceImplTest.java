package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.person.infra.OtpRepository;
import com.barzigan.www.barziganlms.person.model.Otp;
import com.barzigan.www.barziganlms.person.model.dto.OtpRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class OtpServiceImplTest {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private OtpService otpService;

    @BeforeAll
    void setUp() {
        Otp otp = new Otp();
        otp.setUsed(false);
        otp.setOtp("123456");
        otp.setEmail("a@email.com");
        otpRepository.save(otp);
    }

    @Test
    void isOtpValid() {
        var dto = OtpRequestDto.builder().email("a@email.com").otp("123456").build();
     Assertions.assertTrue(otpService.isOtpValid(dto));


    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}