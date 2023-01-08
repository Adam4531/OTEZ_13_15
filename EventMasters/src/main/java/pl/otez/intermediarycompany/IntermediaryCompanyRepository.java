package pl.otez.intermediarycompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntermediaryCompanyRepository extends JpaRepository<IntermediaryCompanyEntity, Long> {
}
