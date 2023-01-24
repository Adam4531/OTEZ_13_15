package pl.otez.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.SuperEntity;
import pl.otez.user.client.ClientEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PAYMENTS")
public class PaymentEntity extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    private LocalDate dateOfPayment;
}
