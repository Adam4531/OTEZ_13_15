package pl.otez.payment.validation;

import pl.otez.interfaces.Validator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class PaymentPrice implements Validator {

    @Column
    private BigDecimal price;


}