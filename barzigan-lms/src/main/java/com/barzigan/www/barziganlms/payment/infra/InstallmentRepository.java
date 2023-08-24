package com.barzigan.www.barziganlms.payment.infra;

import com.barzigan.www.barziganlms.payment.domain.Installment;
import com.barzigan.www.barziganlms.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface InstallmentRepository extends JpaRepository<Installment, Long> {

    List<Installment> findByPayment(Payment payment);

    List<Installment> findByPaymentDate(LocalDate paymentDate);

}
