package pl.otez.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.event.enums.StatusEnum;
import pl.otez.event.typeofevent.TypeOfEventEntity;
import pl.otez.payment.PaymentEntity;
import pl.otez.user.client.ClientEntity;
import pl.otez.user.employee.EmployeeEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "EVENTS")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_of_event_id")
    private TypeOfEventEntity TypeOfEvent;

    private BigDecimal price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_employee_of_event_id")
    private EmployeeEntity headEmployee;

    @Column(name = "date_start_of_event")
    private LocalDate dateStart;

    @Column(name = "date_end_of_event")
    private LocalDate dateEnd;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

}
