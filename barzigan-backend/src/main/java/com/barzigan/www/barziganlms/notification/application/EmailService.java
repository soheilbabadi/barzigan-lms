package com.barzigan.www.barziganlms.notification.application;

import com.barzigan.www.barziganlms.notification.model.EmailDto;

public interface EmailService {
    void sendEmail(EmailDto dto);
}
