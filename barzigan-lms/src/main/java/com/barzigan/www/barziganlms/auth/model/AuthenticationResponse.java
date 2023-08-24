package com.barzigan.www.barziganlms.auth.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 9015213464421899929L;
    private String token;

    private String firstName;

    private String lastName;

    private String email;
    private String username;

    private String phoneNumber;

    private String address;

    private String postalCode;

    private String city;

    private String province;

    private String nationalCode;

    private LocalDate birthDate;

    private LocalDateTime registerDate;

    private String role;

    private LocalDateTime registerOn;

    private LocalDateTime lastLoginOn;

    private boolean verified;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;
}
