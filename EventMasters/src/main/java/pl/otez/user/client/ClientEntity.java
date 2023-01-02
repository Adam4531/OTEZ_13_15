package pl.otez.user.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.user.client.validation.EmailValidator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "CLIENTS")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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

    void changeEmail(String aEmail) {
        this.email = new EmailValidator(aEmail);
    }
}
