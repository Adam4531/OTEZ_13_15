package pl.otez.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Autowired
    public EventService(EventRepository aEventRepository, EventMapper aEventMapper) {
        eventRepository = aEventRepository;
        eventMapper = aEventMapper;
    }
}
