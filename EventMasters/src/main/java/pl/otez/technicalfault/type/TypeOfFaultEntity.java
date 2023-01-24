package pl.otez.technicalfault.type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.otez.SuperEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "TYPES_OF_FAULTS")
public class TypeOfFaultEntity extends SuperEntity {

    private String type;
}
