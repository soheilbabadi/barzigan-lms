package com.barzigan.www.barziganlms.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Installment implements Serializable {
    @Serial
    private static final long serialVersionUID = -7553897844184310410L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime paymentDate;
    private short partNo;


    @ManyToOne(targetEntity = Payment.class, cascade = CascadeType.ALL)
    private Payment payment;
}
