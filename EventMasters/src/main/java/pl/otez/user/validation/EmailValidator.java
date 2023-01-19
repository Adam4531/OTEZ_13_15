package pl.otez.user.validation;

import lombok.NoArgsConstructor;
import pl.otez.interfaces.Validator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class EmailValidator implements Validator {

    private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\""
        + "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\""
        + ")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]"
        + "?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e"
        + "-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    @Column
    private String email;

    public EmailValidator(String aEmail){
        if(Objects.isNull(aEmail)){
            throw new IllegalArgumentException("Email can not be null!");
        }
        if(!isValidLength(email, 5, 45)){
            throw new IllegalArgumentException("Email must be between 5 to 45 characters length!");
        }
        if(!containsValidCharacters(email, EMAIL_PATTERN)){
            throw new IllegalArgumentException("Email may contain only letters, digits, and '@' '.' signs!");
        }
        this.email = aEmail;
    }

    @Override
    public String toString() {
        return email;
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass()) return false;
        EmailValidator that = (EmailValidator) aO;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
