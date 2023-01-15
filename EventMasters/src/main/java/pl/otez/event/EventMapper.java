package pl.otez.event;

import org.springframework.stereotype.Component;
import pl.otez.event.dto.EventDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {
    EventDto fromEventEntityToEventDto(EventEntity aEventEntity) {
        return EventDto.builder()
                .id(aEventEntity.getId())
                .typeOfEventEntity(aEventEntity.getTypeOfEvent())
                .price(aEventEntity.getPrice())
                .payment(aEventEntity.getPayment())
                .headEmployee(aEventEntity.getHeadEmployee())
                .dateStart(aEventEntity.getDateStart())
                .dateEnd(aEventEntity.getDateEnd())
                .status(aEventEntity.getStatus())
                .client(aEventEntity.getClient())
                .build();
    }

    List<EventDto> fromEventEntitiesListToEventDtoList(List<EventEntity> aEventEntities) {
        return aEventEntities.stream().map(this::fromEventEntityToEventDto).collect(Collectors.toList());
    }
}
