package com.barzigan.www.barziganlms.notification.model;

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

    private String to;
    private String subject;
    private String body;

}
