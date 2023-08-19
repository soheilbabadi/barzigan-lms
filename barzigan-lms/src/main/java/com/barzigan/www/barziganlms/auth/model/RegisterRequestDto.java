package com.barzigan.www.barziganlms.auth.model;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -2755960199028095743L;
@Email(message = "email is not valid")

    private String email;
    private String password;
}
