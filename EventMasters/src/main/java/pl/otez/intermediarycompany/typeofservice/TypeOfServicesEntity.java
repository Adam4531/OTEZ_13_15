package pl.otez.intermediarycompany.typeofservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.intermediarycompany.IntermediaryCompanyEntity;
import pl.otez.intermediarycompany.typeofservice.validation.NameValidator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TYPES_OF_SERVICES")
public class TypeOfServicesEntity {


//    @OneToMany(mappedBy = "Id", fetch = FetchType.LAZY)
//    private List<IntermediaryCompanyEntity> intermediarycompanyEntity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Embedded
    private NameValidator name;

    void changeName(String name) {
        this.name = new NameValidator(name);
    }
}
