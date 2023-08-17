package com.barzigan.www.barziganlms.person.model;

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
public class LoginDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3781407433028672507L;

    private String username;
    private String password;
}
