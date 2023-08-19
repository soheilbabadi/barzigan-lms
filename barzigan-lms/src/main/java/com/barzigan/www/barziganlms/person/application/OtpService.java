package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.person.model.dto.OtpDto;

public interface OtpService {
    OtpDto findOtp(OtpDto dto);

    void save(String email);

    void delete();
}
