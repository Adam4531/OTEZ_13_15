package pl.otez.user.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.otez.user.ErrorsListDto;
import pl.otez.user.client.dto.ClientEditRequestDto;
import pl.otez.user.client.dto.ClientResponseDto;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    private final ClientEditService clientEditService;

    @Autowired
    ClientController(ClientService aClientService, ClientEditService aClientEditService) {
        clientService = aClientService;
        clientEditService = aClientEditService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientResponseDto> getClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDto getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    //TODO ClientEditService
//    @GetMapping("")
//    @ResponseStatus(HttpStatus.OK)
//    public ClientEditRequestDto getClientByEmail(@RequestParam String email){
//        return clientEditService.getClientEditRequestDtoByEmail(email);
//    }

    //TODO ClientEditService
//    @PutMapping("")
//    @ResponseStatus(HttpStatus.OK)
//    public ErrorsListDto changeClientByEmail(@RequestParam String email, @RequestBody ClientEditRequestDto updatedClient){
//        return clientEditService.updateClientByEmail(email, updatedClient);
//    }

    //TODO ClientEditService
//    @PatchMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ClientResponseDto changeClientEmail(@PathVariable Long id, @RequestParam String email){
//        return clientEditService.updateClientEmail(id, email);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteClientById(@RequestParam Long id){
        return clientService.deleteClientById(id);
    }

}
