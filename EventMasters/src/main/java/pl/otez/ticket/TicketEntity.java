package pl.otez.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.ticket.validation.PricePerUnitValidator;

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

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = client)
    private Long client_id;

//    @Embedded
    private BigDecimal pricePerUnit;

    private Long event_id;

    void changePricePerUnit(BigDecimal aPricePerUnit) {
//        this.pricePerUnit = new PricePerUnitValidator(aPricePerUnit);
        this.pricePerUnit = aPricePerUnit;
    }
}
