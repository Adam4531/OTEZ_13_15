package pl.otez.user.validation;

import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.otez.interfaces.Validator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class PasswordValidator implements Validator {
    private static final String ENGLISH_LETTERS_WITH_NUMBERS_AND_SPECIAL_CHARACTERS="[\\x21-\\x7E]+";
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Column
    private String password;

    public PasswordValidator(String aPassword){
        if(Objects.isNull(aPassword)){
            throw new IllegalStateException("Password can not be null!");
        }
        if(!isValidLength(aPassword, 7, 30)){
            throw new IllegalStateException("Password length must be between 7 and 30 characters!");
        }
        if(!containsValidCharacters(aPassword,ENGLISH_LETTERS_WITH_NUMBERS_AND_SPECIAL_CHARACTERS)){
            throw new IllegalStateException("Password must contain only english letters, numbers and special characters!");
        }
//        aPassword = encryptPassword(aPassword);
        this.password = aPassword;
    }

//    private String encryptPassword(String aPassword){
//        return passwordEncoder.encode(aPassword);
//    }

    public String toString() {
        return password;
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass()) return false;
        PasswordValidator that = (PasswordValidator) aO;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}
