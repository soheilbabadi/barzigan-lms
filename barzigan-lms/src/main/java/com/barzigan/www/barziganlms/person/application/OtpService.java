package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.person.model.dto.OtpRequestDto;

public interface OtpService {

    boolean isOtpValid(OtpRequestDto dto);

    void save(String email);

    void delete();
}
