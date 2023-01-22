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
                .typeOfEventEntityId(aEventEntity.getTypeOfEvent().getId())
                .price(aEventEntity.getPrice())
                .paymentId(aEventEntity.getPayment().getId())
                .headEmployeeId(aEventEntity.getHeadEmployee().getId())
                .dateStart(aEventEntity.getDateStart())
                .dateEnd(aEventEntity.getDateEnd())
                .status(aEventEntity.getStatus())
                .clientId(aEventEntity.getClient().getId())
                .build();
    }

    List<EventDto> fromEventEntitiesListToEventDtoList(List<EventEntity> aEventEntities) {
        return aEventEntities.stream().map(this::fromEventEntityToEventDto).collect(Collectors.toList());
    }
}
