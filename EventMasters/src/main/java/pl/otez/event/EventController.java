package pl.otez.event;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.otez.event.dto.EventDto;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventDto getEventById(@PathVariable Long id) {
        return eventService.findEventById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public EventDto addEvent(@RequestBody EventEntity aEventEntity) {
        return eventService.addEvent(aEventEntity);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Long id, @RequestBody EventEntity aEventEntity) {
        EventDto updatedEvent = eventService.updateEvent(id, aEventEntity);
        final HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.add("HEADER",
                "Event with id:" + aEventEntity.getId() + " has been successfully updated!");
        return new ResponseEntity<>(updatedEvent, httpHeader, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<EventDto> deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        final HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.add("HEADER",
                "Event with id:" + id + " has been successfully deleted!");
        return new ResponseEntity<>(httpHeader, HttpStatus.ACCEPTED);
    }

}
