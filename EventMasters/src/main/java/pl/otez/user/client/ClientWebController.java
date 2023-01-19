package pl.otez.user.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.otez.user.ErrorsListDto;
import pl.otez.user.client.dto.ClientLoginDto;
import pl.otez.user.client.dto.ClientLoginResponseDto;
import pl.otez.user.client.dto.ClientRequestDto;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientWebController {

    private final ClientLoginService clientLoginService;
    private final ClientRegistrationService clientRegistrationService;

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientLoginResponseDto> login(@RequestBody ClientLoginDto client){
        return ResponseEntity.ok(clientLoginService.login(client));
    }

    @PostMapping("/registration")
    public ErrorsListDto create(@RequestBody ClientRequestDto client){
        return clientRegistrationService.register(client);
    }


}
