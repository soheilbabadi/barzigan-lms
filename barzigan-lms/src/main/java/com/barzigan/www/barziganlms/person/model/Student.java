package com.barzigan.www.barziganlms.person.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Student implements UserDetails {


    @Serial
    private static final long serialVersionUID = -8201159332089107693L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @Column(nullable = false, length = 10, columnDefinition = "varchar(10)")
    private String nationalCode;

    @Column(nullable = false)
    private LocalDate birthDate;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String username;


    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime registerOn;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime lastLoginOn;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean verified;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean accountNonExpired;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean accountNonLocked;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean credentialsNonExpired;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
}
