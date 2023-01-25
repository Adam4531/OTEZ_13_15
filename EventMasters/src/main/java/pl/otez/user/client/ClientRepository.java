package pl.otez.user.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.otez.user.validation.EmailValidator;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findClientByEmail(EmailValidator email);
    ClientEntity findClientEntityByEmail(EmailValidator email);
}
