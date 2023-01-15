package pl.otez.ticket.validation;

import lombok.NoArgsConstructor;
import pl.otez.interfaces.Validator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@NoArgsConstructor
@Embeddable
public class PricePerUnitValidator implements Validator  {

    @Column
    private BigDecimal pricePerUnit;

    public PricePerUnitValidator(BigDecimal aPricePerUnit){
        if(Objects.isNull(aPricePerUnit)){
            throw new IllegalArgumentException("Price per unit can not be null!");
        }
        if(aPricePerUnit.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Price per unit can not be less than or equal to zero!");
        }
        this.pricePerUnit = aPricePerUnit;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public String toString() {
        return pricePerUnit.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricePerUnitValidator that = (PricePerUnitValidator) o;
        return pricePerUnit.equals(that.pricePerUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pricePerUnit);
    }
}

