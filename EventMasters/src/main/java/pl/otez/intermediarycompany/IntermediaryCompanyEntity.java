package pl.otez.intermediarycompany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.intermediarycompany.typeofservice.TypeOfServicesEntity;
import pl.otez.intermediarycompany.validation.NameValidator;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "INTERMEDIARY_COMPIANIES")
public class IntermediaryCompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="NIP")
    private String NIP;

    @Column(name="nameOfCompany")
    private NameValidator name_of_company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeOfService_ID", nullable = false)
    private TypeOfServicesEntity typeOfServiceId;

    void changeName(String nameOfCompany) {
        this.name_of_company = new NameValidator(nameOfCompany);
    }
}

