package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.notification.application.EmailService;
import com.barzigan.www.barziganlms.notification.model.EmailDto;
import com.barzigan.www.barziganlms.person.infra.OtpRepository;
import com.barzigan.www.barziganlms.person.model.Otp;
import com.barzigan.www.barziganlms.person.model.dto.OtpDto;
import com.barzigan.www.barziganlms.utils.RandomString;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {

    @Autowired
    private  OtpRepository otpRepository;
    @Autowired
    private  EmailService emailService;

    @Override
    public OtpDto findOtp(OtpDto dto) {
        var entity = otpRepository.findByEmailAndOtpAndExpireAtAfter(dto.getEmail(), dto.getOtp(), LocalDateTime.now(ZoneOffset.UTC))
                .orElseThrow(() -> new RuntimeException("otp not found"));
        entity.setUsed(true);
        otpRepository.save(entity);

        return OtpDto.builder().id(entity.getId()).email(entity.getEmail()).otp(entity.getOtp()).expireAt(entity.getExpireAt()).used(true).createdAt(entity.getCreatedAt()).build();
    }

    @Override
    public void save(String email) {

        var entity = Otp.builder().email(email)
                .otp(RandomString.gerRandomString(8))
                .expireAt(LocalDateTime.now(ZoneOffset.UTC).plusMinutes(20))
                .used(false)
                .createdAt(LocalDateTime.now(ZoneOffset.UTC)).build();
        otpRepository.save(entity);

        EmailDto dto=new EmailDto();
        dto.setTo(email);
        dto.setSubject("سیستم آموزش برزیگان");
        dto.setBody("کد فعال سازی شما: "+entity.getOtp());
        emailService.sendEmail(dto);
    }

    @Override
    public void delete() {
        otpRepository.deleteAll(otpRepository.findAllByExpireAtBefore(LocalDateTime.now(ZoneOffset.UTC)));
        otpRepository.deleteAll(otpRepository.findAllByUsed(true));
    }
}
