package pl.otez.user.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.otez.user.ErrorsListDto;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ClientLoginResponseDto implements Serializable {

    private String sessionId;
    private ErrorsListDto errorsListDto;

    public ClientLoginResponseDto(ErrorsListDto aErrorsListDto) {
        errorsListDto = aErrorsListDto;
    }

    public void addToErrorList(String error){
        this.errorsListDto.add(error);
    }
}
