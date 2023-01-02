package pl.otez.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserWebController {

    private final UserLoginService userLoginService;
    private final UserRegistrationService userRegistrationService;
}
