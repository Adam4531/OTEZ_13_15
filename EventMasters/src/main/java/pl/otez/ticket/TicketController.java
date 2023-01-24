package pl.otez.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pl.otez.ticket.dto.TicketDto;


import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    TicketController(TicketService aTicketService) {
        ticketService = aTicketService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<TicketDto> getTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TicketDto getTicketById(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteTicketById(@RequestParam Long id){
        return ticketService.deleteTicketById(id);
    }

}
