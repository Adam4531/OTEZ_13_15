package pl.otez.ticket.dto;

import lombok.Builder;

import java.math.BigDecimal;

public record TicketEditRequestDto(BigDecimal price_per_unit) {

    @Builder
    public TicketEditRequestDto{

    }
}
