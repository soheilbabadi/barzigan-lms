package com.barzigan.www.barziganlms.course.model;

import com.barzigan.www.barziganlms.payment.domain.Payment;
import jakarta.persistence.*;
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
@Entity
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = -5051452088078786529L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 50, columnDefinition = "varchar(50)")
    private String title;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime updatedDate;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime finishDate;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private BigDecimal tuition;


@Column(nullable = false, length = 1000, columnDefinition = "varchar(1000)")
    private String description;

    @Column(nullable = false)
    private boolean archived;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Topic> topics;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Detail> details;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Payment> payments;

}
