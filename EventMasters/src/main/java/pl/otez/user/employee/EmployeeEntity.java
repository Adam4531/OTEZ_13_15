package pl.otez.user.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.SuperEntity;
import pl.otez.user.employee.position.PositionEntity;
import pl.otez.user.validation.EmailValidator;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "EMPLOYEES")
public class EmployeeEntity extends SuperEntity {

    private String firstName;

    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @Column(unique = true)
    private EmailValidator email;

    private String password;

    @Builder
    public EmployeeEntity(String aFirstName, String aLastName, PositionEntity aPosition, EmailValidator aEmail, String aPassword) {
        firstName = aFirstName;
        lastName = aLastName;
        position = aPosition;
        email = aEmail;
        password = aPassword;
    }
}
