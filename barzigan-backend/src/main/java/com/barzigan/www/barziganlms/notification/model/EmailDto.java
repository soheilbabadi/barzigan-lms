package com.barzigan.www.barziganlms.notification.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class EmailDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3290881766745572078L;

    @Email(message = "Email should be valid")
    private String to;
    @NotBlank(message = "Subject should not be blank")
    private String subject;
    @NotBlank(message = "Body should not be blank")
    private String body;

}
