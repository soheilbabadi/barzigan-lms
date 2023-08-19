package com.barzigan.www.barziganlms.person.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class OtpDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -7906717162484987494L;


    private long id;

    private String email;
    private String otp;
    private LocalDateTime expireAt;
    private boolean used;
    private LocalDateTime createdAt;
}
