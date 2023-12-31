package com.barzigan.www.barziganlms.course.model;

import jakarta.persistence.*;
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
@Entity
public class Detail implements Serializable {
    @Serial
    private static final long serialVersionUID = -2594216924661127318L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,length = 65535 ,columnDefinition = "varchar(65535)")
    private String courseDetail;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Course.class)
    private Course course;
}
