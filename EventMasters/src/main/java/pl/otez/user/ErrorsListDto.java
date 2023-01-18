package pl.otez.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ErrorsListDto{

    private List<String> errors;
    private String fieldName;

    public ErrorsListDto(List<String> aErrors) {
        errors = aErrors;
    }

    public boolean isListOfErrorsEmpty(){
        return this.errors.size()==0;
    }

    public void add(String error){
        errors.add(error);
    }
}
