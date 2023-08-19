package com.barzigan.www.barziganlms.person.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentUpdateDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 3330359019687867399L;

    private Long id;

    private String firstName;

    private String lastName;

    private String email;


    private String phoneNumber;

    private String address;

    private String postalCode;

    private String city;

    private String province;

    private String nationalCode;

    private LocalDate birthDate;







}
