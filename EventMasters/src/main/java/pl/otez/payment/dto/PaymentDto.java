package pl.otez.payment.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentDto(Long id, BigDecimal price, Long clientId, LocalDate dateOfPayment) {

    @Builder
    public PaymentDto {
    }
}
