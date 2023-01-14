package pl.otez.event.supply.dto;

import lombok.Builder;

public record SupplyDto(Long id, String name, String units) {

    @Builder
    public SupplyDto {
    }
}
