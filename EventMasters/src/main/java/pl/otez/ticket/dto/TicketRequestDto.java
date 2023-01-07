package pl.otez.ticket.dto;

import lombok.Builder;

public record TicketRequestDto(Long id, Long client_id, Long price_per_unit, Long event_id) {
    @Builder
    public TicketRequestDto{}
}
