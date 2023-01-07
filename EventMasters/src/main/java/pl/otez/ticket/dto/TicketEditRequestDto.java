package pl.otez.ticket.dto;

import lombok.Builder;

public record TicketEditRequestDto(Long price_per_unit) {

    @Builder
    public TicketEditRequestDto{

    }
}
