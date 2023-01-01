package pl.otez.client;

import lombok.Getter;
import lombok.NoArgsConstructor;

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

//    @Embedded
//    private Email email;
    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private String password;

    private LocalDate createdTime;

    private String NIP;

    private String nameOfCompany;
}
