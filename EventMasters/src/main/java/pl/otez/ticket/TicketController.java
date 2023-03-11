package pl.otez.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.otez.ticket.dto.TicketDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<TicketDto> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TicketDto getTicketById(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public TicketDto addTicket(@RequestBody TicketEntity aTicketEntity){
        return ticketService.addTicket(aTicketEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable Long id, @RequestBody TicketEntity aTicketEntity){
        TicketDto ticketDto = ticketService.updateTicket(id, aTicketEntity);

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "Ticket with id: " + id + " has been succesfully updated");
        return new ResponseEntity<>(ticketDto, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteTicketById(@RequestParam Long id){
        return ticketService.deleteTicketById(id);
    }

}
