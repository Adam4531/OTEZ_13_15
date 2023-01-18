package pl.otez.user.employee.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.otez.user.ErrorsListDto;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeLoginResponseDto{

    private String sessionId;
    private ErrorsListDto errorsListDto;

    public EmployeeLoginResponseDto(ErrorsListDto aErrorsListDto) {
        errorsListDto = aErrorsListDto;
    }

    public void addToErrorList(String error){
        this.errorsListDto.add(error);
    }
}
