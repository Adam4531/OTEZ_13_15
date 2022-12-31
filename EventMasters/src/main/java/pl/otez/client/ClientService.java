package pl.otez.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientMapper aClientMapper, ClientRepository aClientRepository) {
        clientMapper = aClientMapper;
        clientRepository = aClientRepository;
    }
}
