package pl.otez.user.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientEditService {

    private final ClientMapper clientMapper;

    @Autowired
    public ClientEditService(ClientMapper aClientMapper) {
        clientMapper = aClientMapper;
    }

//    ClientEditRequestDto getClientEditRequestDtoByEmail(String aEmail) {
//        return new ClientEditRequestDto();
//    }

//    ErrorsListDto updateClientByEmail(String aEmail, ClientEditRequestDto aUpdatedClient) {
//        EmailValidator emailValidator = new EmailValidator(aEmail);
//    }

//    ClientResponseDto updateClientEmail(Long aId, String aEmail) {
//        return new ClientResponseDto();
//    }
}
