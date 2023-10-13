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
public class Topic implements Serializable {

    @Serial
    private static final long serialVersionUID = 2150470412661935056L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 150, columnDefinition = "varchar(150)")
    private String title;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Course.class)
    private Course course;

}
