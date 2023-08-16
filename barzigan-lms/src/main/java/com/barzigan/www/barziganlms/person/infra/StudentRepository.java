package com.barzigan.www.barziganlms.person.infra;

import com.barzigan.www.barziganlms.person.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    Optional<Student> findByNationalCode(String nationalCode);

    Optional<Student> findByPhoneNumber(String phoneNumber);


    Optional<Student> findByNationalCodeOrEmailAndPassword(String nationalCode, String email, String password);

}
