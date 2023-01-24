package pl.otez.technicalfault;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.SuperEntity;
import pl.otez.technicalfault.enums.TechincalStatus;
import pl.otez.technicalfault.type.TypeOfFaultEntity;
import pl.otez.user.employee.EmployeeEntity;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "TECHNICAL_FAULTS")
public class TechnicalFaultEntity extends SuperEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_of_Fault_id")
    private TypeOfFaultEntity typeOfFault;

    private String description;

    @Enumerated(EnumType.STRING)
    private TechincalStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;
}


