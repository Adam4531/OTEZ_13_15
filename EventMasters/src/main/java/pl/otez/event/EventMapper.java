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

                .build();
    }

    List<EventDto> fromEventEntitiesListToEventDtoList(List<EventEntity> aEventEntities) {
        return aEventEntities.stream().map(this::fromEventEntityToEventDto).collect(Collectors.toList());
    }
}
