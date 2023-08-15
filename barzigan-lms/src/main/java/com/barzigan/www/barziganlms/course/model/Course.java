package com.barzigan.www.barziganlms.course.model;

import com.barzigan.www.barziganlms.person.model.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = -5051452088078786529L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String title;


    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime finishDate;

    @Column(nullable = false)
    private int capacity;

    private int preRequirement;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Topic> topics;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Detail> details;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Payment> payments;



}
