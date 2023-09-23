package com.barzigan.www.barziganlms.payment.domain;

public enum PaymentStatus {
    PAID("paid"),
    UNPAID("unpaid"),
    VERIFIED("verified"),
    CANCELED("canceled");

    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return status;
    }

}
