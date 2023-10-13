package com.barzigan.www.barziganlms.person.infra;

import com.barzigan.www.barziganlms.person.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findByEmailAndOtpAndExpireAtAfterAndUsed(String email, String otp, LocalDateTime localDateTime, boolean used);

    void deleteAllByExpireAtBeforeOrUsed(LocalDateTime localDateTime, boolean used);


}
