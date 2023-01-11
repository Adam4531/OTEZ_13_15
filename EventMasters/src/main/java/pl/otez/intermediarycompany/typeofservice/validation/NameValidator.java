package pl.otez.intermediarycompany.typeofservice.validation;

import lombok.NoArgsConstructor;
import pl.otez.interfaces.Validator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class NameValidator implements Validator {
    @Column(name="name")
    private String name;

    public NameValidator(String aName){
        if(Objects.isNull(aName)){
            throw new IllegalArgumentException("Name can not be null!");
        }
        if(aName.length()>=40){
            throw new IllegalArgumentException("Name can not be greater than or equal to 50!");
        }
        if(aName.length()<=0){
            throw new IllegalArgumentException("Name can not be less than or equal to 0!");
        }
        this.name= aName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString()  {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameValidator that = (NameValidator) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
