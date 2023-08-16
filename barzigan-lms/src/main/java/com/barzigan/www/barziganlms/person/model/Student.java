package com.barzigan.www.barziganlms.person.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Student implements Serializable {


    @Serial
    private static final long serialVersionUID = -8201159332089107693L;

    @Id
    private long id;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String firstName;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String lastName;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String email;
    @Column(nullable = false, length = 500, columnDefinition = "varchar(500)")
    private String password;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String phoneNumber;

    @Column(nullable = false, length = 500, columnDefinition = "varchar(500)")
    private String address;

    @Column(nullable = false, length = 15, columnDefinition = "varchar(10)")
    private String postalCode;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String city;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String province;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String country;

    @Column(nullable = false, length = 10, columnDefinition = "varchar(10)")
    private String nationalCode;

    @Column(nullable = false, length = 10, columnDefinition = "varchar(10)")
    private String birthDate;

    private LocalDateTime registerDate;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String role;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String username;

}
