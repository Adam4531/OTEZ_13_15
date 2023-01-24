package pl.otez.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
