package pl.otez.intermediarycompany.typeofservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfServicesRepository extends JpaRepository<TypeOfServicesEntity, Long> {

}
