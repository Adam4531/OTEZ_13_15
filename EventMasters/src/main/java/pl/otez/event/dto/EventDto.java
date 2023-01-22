package pl.otez.event.dto;

import lombok.Builder;
import pl.otez.event.enums.StatusEnum;
import pl.otez.event.typeofevent.TypeOfEventEntity;
import pl.otez.payment.PaymentEntity;
import pl.otez.user.client.ClientEntity;
import pl.otez.user.employee.EmployeeEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EventDto(Long id, Long typeOfEventEntityId, BigDecimal price, Long paymentId,
                       Long headEmployeeId, LocalDate dateStart, LocalDate dateEnd, StatusEnum status,
                       Long clientId) {

    @Builder
    public EventDto {
    }
}
