package pl.otez.payment;

import org.springframework.stereotype.Component;
import pl.otez.payment.dto.PaymentDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMapper {
    public PaymentDto fromPaymentEntityToPaymentDto(PaymentEntity aPayment) {
        return PaymentDto.builder()
                .id(aPayment.getId())
                .price(aPayment.getPrice())
                .client_id(aPayment.getClient().getId())
                .dateOfPayment(aPayment.getDateOfPayment())
                .build();
    }

    public List<PaymentDto> fromPaymentEntityListToPaymentDtoList(List<PaymentEntity> aPaymentEntityList){
        return aPaymentEntityList.stream().map(this::fromPaymentEntityToPaymentDto).collect(Collectors.toList());
    }
}
