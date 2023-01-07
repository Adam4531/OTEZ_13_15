package pl.otez.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.ticket.validation.PricePerUnitValidator;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TICKETS")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long client_id;

    @Embedded
    private PricePerUnitValidator price_per_unit;

    private Long event_id;

    void changePricePerUnit(Long aPricePerUnit) {
        this.price_per_unit = new PricePerUnitValidator(aPricePerUnit);
    }
}
