package pl.otez.ticket.validation;

import lombok.NoArgsConstructor;
import pl.otez.interfaces.Validator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class PricePerUnitValidator implements Validator  {

    @Column(name="price_per_unit")
    private Long pricePerUnit;

    public PricePerUnitValidator(Long aPricePerUnit){
        if(Objects.isNull(aPricePerUnit)){
            throw new IllegalArgumentException("Price per unit can not be null!");
        }
        if(0>=aPricePerUnit){
            throw new IllegalArgumentException("Price per unit can not be less than or equal to zero!");
        }
        this.pricePerUnit = aPricePerUnit;
    }

    public Long getPricePerUnit() {
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