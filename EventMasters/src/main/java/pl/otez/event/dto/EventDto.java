package pl.otez.event.dto;

import lombok.Builder;
import pl.otez.event.enums.StatusEnum;
import pl.otez.event.typeofevent.TypeOfEventEntity;
import pl.otez.payment.PaymentEntity;
import pl.otez.user.client.ClientEntity;
import pl.otez.user.employee.EmployeeEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EventDto(Long id, TypeOfEventEntity typeOfEventEntity, BigDecimal price, PaymentEntity payment,
                       EmployeeEntity headEmployee, LocalDate dateStart, LocalDate dateEnd, StatusEnum status,
                       ClientEntity client) {

    @Builder
    public EventDto {
    }
}
