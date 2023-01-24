package pl.otez.technicalfault;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalFaultRepository extends JpaRepository<TechnicalFaultEntity ,Long> {
}
