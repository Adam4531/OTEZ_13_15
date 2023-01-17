package pl.otez.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.event.EventEntity;
import pl.otez.ticket.validation.PricePerUnitValidator;
import pl.otez.user.client.ClientEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TICKETS")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Embedded
    private PricePerUnitValidator pricePerUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private EventEntity event;

    void changePricePerUnit(BigDecimal aPricePerUnit) {
        this.pricePerUnit = new PricePerUnitValidator(aPricePerUnit);
    }
}
