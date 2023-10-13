package com.barzigan.www.barziganlms.course.model;

import com.barzigan.www.barziganlms.utils.KeyValDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CourseDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 310049177060790421L;
    private long id;

    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    private int capacity;

    private BigDecimal tuition;


    private boolean archived;

    private Set<KeyValDto> topics;

    private Set<KeyValDto> details;


}
