package com.barzigan.www.barziganlms.person.application;

import com.barzigan.www.barziganlms.notification.application.EmailService;
import com.barzigan.www.barziganlms.notification.model.EmailDto;
import com.barzigan.www.barziganlms.person.infra.OtpRepository;
import com.barzigan.www.barziganlms.person.model.Otp;
import com.barzigan.www.barziganlms.person.model.dto.OtpRequestDto;
import com.barzigan.www.barziganlms.utils.RandomString;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {


    private final OtpRepository otpRepository;

    private final EmailService emailService;

    @Value("${otp.expire.time}")
    private int expireTime;

    @Value("${otp.email.subject}")
    private String emailSubject;

    @Override
    public boolean isOtpValid(OtpRequestDto dto) {
        var result = otpRepository.findByEmailAndOtpAndExpireAtAfterAndUsed
                (dto.getEmail(), dto.getOtp(), LocalDateTime.now(ZoneOffset.UTC), false);
        if (result.isPresent()) {
            result.get().setUsed(true);
            otpRepository.save(result.get());
            return true;
        }
        return false;
    }

    @Override
    public void save(String email) {

        this.delete();

        var entity = Otp.builder().email(email)
                .otp(RandomString.gerRandomString(8))
                .expireAt(LocalDateTime.now(ZoneOffset.UTC).plusMinutes(expireTime))
                .used(false)
                .createdAt(LocalDateTime.now(ZoneOffset.UTC)).build();
        otpRepository.save(entity);

        String mailBody = String.format("کد فعال سازی شما برای ورود به سیستم آموزش برزیگان: %s", entity.getOtp());
        EmailDto dto = EmailDto.builder().body(mailBody).subject(emailSubject).to(email).build();
        emailService.sendEmail(dto);
    }

    @Override
    public void delete() {
        otpRepository.deleteAllByExpireAtBeforeOrUsed(LocalDateTime.now(ZoneOffset.UTC), true);
    }
}
