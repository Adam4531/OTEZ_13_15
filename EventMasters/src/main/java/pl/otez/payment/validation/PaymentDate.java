package pl.otez.payment.validation;

import pl.otez.interfaces.Validator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class PaymentDate implements Validator {

    @Column
    private LocalDate date;

}
