package com.barzigan.www.barziganlms.payment;

import com.barzigan.www.barziganlms.course.model.Course;
import com.barzigan.www.barziganlms.person.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = -3584094657590501009L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Student.class)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Course.class)
    private Course course;

    private long price;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String paymentStatus;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean verified;

}
