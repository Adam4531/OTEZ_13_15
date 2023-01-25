package pl.otez.payment;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.otez.payment.dto.PaymentDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentDto> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentDto getPaymentById(@PathVariable Long id){
        return paymentService.findPaymentById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDto addPayment(@RequestBody PaymentEntity aPaymentEntity){
        return paymentService.addpayment(aPaymentEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> updatePayment(@PathVariable Long id, @RequestBody PaymentEntity aPaymentEntity){
        PaymentDto paymentDto = paymentService.updatePayment(id, aPaymentEntity);

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "Payment with id:" + aPaymentEntity.getId() + " has been successfully updated");
        return new ResponseEntity<>(paymentDto, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentDto> deletePayment(@PathVariable Long id){
        paymentService.deletePaymentById(id);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "Payment with id:" + id + " has been successfully deleted");
        return new ResponseEntity<>(httpHeaders, HttpStatus.ACCEPTED);
    }
}
