package com.barzigan.www.barziganlms.person.infra;

import com.barzigan.www.barziganlms.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByStudent(long student);

    List<Payment> findByCourse(long course);

    List<Payment> findByStudentAndCourse(long student, long course);


}
