package com.barzigan.www.barziganlms.payment.infra;

import com.barzigan.www.barziganlms.course.model.Course;
import com.barzigan.www.barziganlms.payment.domain.Payment;
import com.barzigan.www.barziganlms.person.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllByCourseAndStudent(Course course, Student student);

    List<Payment> findAllByCourse(Course course);

    List<Payment> findAllByStudent(Student student);


}
