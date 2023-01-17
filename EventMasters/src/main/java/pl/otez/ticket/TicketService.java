package pl.otez.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.otez.ticket.dto.TicketDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TicketService {
    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketMapper aTicketMapper, TicketRepository aTicketRepository) {
        ticketMapper = aTicketMapper;
        ticketRepository = aTicketRepository;
    }

    public List<TicketDto> getAllTickets(){
        var clients = ticketRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return ticketMapper.fromTicketEntityListToTicketDto(clients);
    }

    public TicketEntity getTicket(Long id){
        return ticketRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("Ticket with id:" + id + " does not exist!"));
    }

    public TicketDto getTicketById(Long id){
        TicketEntity ticket = getTicket(id);
        return ticketMapper.fromTicketEntityToTicketDto(ticket);
    }

    public TicketDto updateTicketPricePerUnit(Long id, BigDecimal pricePerUnit){
        TicketEntity ticket = getTicket(id);
        ticket.changePricePerUnit(pricePerUnit);
        ticketRepository.save(ticket);
        return ticketMapper.fromTicketEntityToTicketDto(ticket);
    }

    public String deleteTicketById(Long id){
        TicketEntity ticket = getTicket(id);
        ticketRepository.delete(ticket);
        return "Ticket with id:" + id + " has been succesfully deleted!";
    }

}
