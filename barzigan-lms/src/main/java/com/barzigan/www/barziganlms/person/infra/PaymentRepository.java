package com.barzigan.www.barziganlms.person.infra;

import com.barzigan.www.barziganlms.course.model.Course;
import com.barzigan.www.barziganlms.payment.domain.Payment;
import com.barzigan.www.barziganlms.person.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByStudent(Student student);

    List<Payment> findByCourse(Course course);



}
