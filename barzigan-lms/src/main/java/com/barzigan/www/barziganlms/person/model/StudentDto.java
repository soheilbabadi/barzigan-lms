package com.barzigan.www.barziganlms.person.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 3270359019687867399L;

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private String address;

    private String postalCode;

    private String city;

    private String province;

    private String country;

    private String nationalCode;

    private String birthDate;

    private LocalDateTime registerDate;
    private String role;
    private String username;


    private LocalDateTime registerOn;

    private LocalDateTime lastLoginOn;

    private boolean verified;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;


}
