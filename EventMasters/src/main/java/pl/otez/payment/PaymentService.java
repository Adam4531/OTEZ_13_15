package pl.otez.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.otez.payment.dto.PaymentDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;


    public PaymentDto addpayment(PaymentEntity aPaymentEntity) {
        paymentRepository.save(aPaymentEntity);
        return paymentMapper.fromPaymentEntityToPaymentDto(aPaymentEntity);
    }

    public PaymentEntity getPaymentEntityById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment with id:" + id + "was not found"));
    }

    public PaymentDto findPaymentById(Long id){
        PaymentEntity payment = getPaymentEntityById(id);
        return paymentMapper.fromPaymentEntityToPaymentDto(payment);
    }

    public PaymentDto updatePayment(Long id, PaymentEntity aPaymentEntity){
            PaymentEntity payment = getPaymentEntityById(id);
            paymentRepository.save(aPaymentEntity);
            return paymentMapper.fromPaymentEntityToPaymentDto(payment);
    }

    public void deletePaymentById(Long id){
        paymentRepository.deleteById(id);
    }

    public List<PaymentDto> getAllPayments(){
        List<PaymentEntity> paymentEntityList = paymentRepository.findAll();
        return paymentMapper.fromPaymentEntityListToPaymentDtoList(paymentEntityList);
    }

}
