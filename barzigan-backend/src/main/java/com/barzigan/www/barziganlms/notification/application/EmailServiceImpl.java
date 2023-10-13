package com.barzigan.www.barziganlms.notification.application;

import com.barzigan.www.barziganlms.notification.model.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(EmailDto dto) {
        var simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(dto.getTo());
        simpleMailMessage.setSubject(dto.getSubject());
        simpleMailMessage.setText(dto.getBody());
        javaMailSender.send(simpleMailMessage);

    }
}
