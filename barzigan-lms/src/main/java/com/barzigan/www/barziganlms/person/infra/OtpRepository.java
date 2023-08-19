package com.barzigan.www.barziganlms.person.infra;

import com.barzigan.www.barziganlms.person.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Integer> {

    Optional<Otp> findByEmail(String email);
    List<Otp> findAllByExpireAtBefore(LocalDateTime localDateTime);
    Optional<Otp> findByEmailAndOtpAndExpireAtAfter(String email, String otp, LocalDateTime localDateTime);

    List<Otp> findAllByUsed(boolean used);




}
