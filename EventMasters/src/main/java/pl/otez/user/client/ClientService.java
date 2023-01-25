package pl.otez.user.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.otez.user.client.dto.ClientResponseDto;
import pl.otez.user.validation.EmailValidator;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientMapper aClientMapper, ClientRepository aClientRepository) {
        clientMapper = aClientMapper;
        clientRepository = aClientRepository;
    }

    public List<ClientResponseDto> getAllClients(){
        var clients = clientRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return clientMapper.fromClientEntityListToClientResponseDtoList(clients);
    }

    public ClientEntity findClientById(Long id){
        return clientRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("Client with id:" + id + " does not exist!"));
    }

    public ClientResponseDto getClientById(Long id){
        ClientEntity client = findClientById(id);
        return clientMapper.fromClientEntityToClientResponseDto(client);
    }

    public ClientResponseDto updateClientEmail(Long id, String email){
        ClientEntity client = findClientById(id);
        client.changeEmail(email);
        clientRepository.save(client);
        return clientMapper.fromClientEntityToClientResponseDto(client);
    }

    public String deleteClientById(Long id){
        ClientEntity client = findClientById(id);
        clientRepository.delete(client);
        return "Client with id:" + id + " has been succesfully deleted!";
    }

    public ClientResponseDto getCurrentLoggedClient(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            String email = authentication.getName();
            ClientEntity client = clientRepository.findClientByEmail(new EmailValidator(email));
            return clientMapper.fromClientEntityToClientResponseDto(client);
        }
        return null;
    }


}
