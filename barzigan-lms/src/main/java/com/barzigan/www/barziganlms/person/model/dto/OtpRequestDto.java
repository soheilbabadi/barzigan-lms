package com.barzigan.www.barziganlms.person.model.dto;

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
public class OtpRequestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -791671716248498744L;



    private String email;
    private String otp;

}
