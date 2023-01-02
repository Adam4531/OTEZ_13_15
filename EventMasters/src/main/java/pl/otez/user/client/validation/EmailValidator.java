package pl.otez.user.client.validation;

import lombok.NoArgsConstructor;
import pl.otez.interfaces.Validator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class EmailValidator implements Validator {

    private final String EMAIL_PATTERN = ""; //TODO find REGEX for email validation

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
