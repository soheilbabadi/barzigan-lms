package com.barzigan.www.barziganlms.person.infra;

import com.barzigan.www.barziganlms.person.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail(String email);

    Student findByNationalCode(String nationalCode);

    Student findByPhoneNumber(String phoneNumber);

    Student findByEmailAndPassword(String email, String password);

    Student findByNationalCodeAndPassword(String nationalCode, String password);

    Student findByPhoneNumberAndPassword(String phoneNumber, String password);

    Student findByEmailAndNationalCode(String email, String nationalCode);
}
