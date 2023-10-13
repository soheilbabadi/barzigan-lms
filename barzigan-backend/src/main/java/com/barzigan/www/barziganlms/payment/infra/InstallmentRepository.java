package com.barzigan.www.barziganlms.payment.infra;

import com.barzigan.www.barziganlms.payment.domain.Installment;
import com.barzigan.www.barziganlms.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {

    List<Installment> findByPayment(Payment payment);

    List<Installment> findByPaymentDate(LocalDate paymentDate);

}
