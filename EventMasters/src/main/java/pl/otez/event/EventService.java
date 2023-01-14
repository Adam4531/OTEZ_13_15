package pl.otez.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.otez.event.dto.EventDto;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Autowired
    public EventService(EventRepository aEventRepository, EventMapper aEventMapper) {
        eventRepository = aEventRepository;
        eventMapper = aEventMapper;
    }

    public EventEntity getEventEntityById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event with id:" + id + " was not found"));
    }

    List<EventDto> getAllEvents() {
        List<EventEntity> eventEntities = eventRepository.findAll();
        return eventMapper.fromEventEntitiesListToEventDtoList(eventEntities);
    }

    EventDto findEventById(Long aId) {
        return eventMapper.fromEventEntityToEventDto(getEventEntityById(aId));
    }

    EventDto addEvent(EventEntity aEventEntity) {
        EventEntity savedEventEntity = eventRepository.save(aEventEntity);
        return eventMapper.fromEventEntityToEventDto(savedEventEntity);
    }

    EventDto updateEvent(Long aId, EventEntity aEventEntity) {
        EventEntity eventEntityById = getEventEntityById(aId);
        eventRepository.save(aEventEntity);
        return eventMapper.fromEventEntityToEventDto(aEventEntity);
    }

    void deleteById(Long aId) {
        eventRepository.deleteById(aId);
    }
}
