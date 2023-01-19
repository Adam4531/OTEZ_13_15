package pl.otez.user.client;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.SuperEntity;
import pl.otez.user.validation.EmailValidator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "CLIENTS")
public class ClientEntity extends SuperEntity {

    @Embedded
    @Column(unique = true)
    private EmailValidator email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private String password;

    private LocalDate createdTime;

    private String NIP;

    private String nameOfCompany;

    @Builder
    public ClientEntity(EmailValidator aEmail, String aFirstName, String aLastName, String aPhoneNumber, String aAddress, String aPassword, LocalDate aCreatedTime, String aNIP, String aNameOfCompany) {
        email = aEmail;
        firstName = aFirstName;
        lastName = aLastName;
        phoneNumber = aPhoneNumber;
        address = aAddress;
        password = aPassword;
        createdTime = aCreatedTime;
        NIP = aNIP;
        nameOfCompany = aNameOfCompany;
    }

    void changeEmail(String aEmail) {
        this.email = new EmailValidator(aEmail);
    }
}
