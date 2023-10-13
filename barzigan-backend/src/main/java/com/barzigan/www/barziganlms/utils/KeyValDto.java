package com.barzigan.www.barziganlms.utils;


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
public class KeyValDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1153939195885069775L;

    private long id;
    private String title;
}
