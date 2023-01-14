package pl.otez.event.dto;

import lombok.Builder;

public record EventDto(Long id) {

    @Builder
    public EventDto {
    }
}
