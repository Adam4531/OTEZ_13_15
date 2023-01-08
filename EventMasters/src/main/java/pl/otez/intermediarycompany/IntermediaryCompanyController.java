package pl.otez.intermediarycompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.otez.intermediarycompany.dto.IntermediaryCompanyResponseDto;

import java.util.List;

@RestController
@RequestMapping("/intermediarycompany")
public class IntermediaryCompanyController {
    private final IntermediaryCompanyService intermediarycompanyService;
    @Autowired
    IntermediaryCompanyController(IntermediaryCompanyService aIntermediaryCompanyService){
        intermediarycompanyService = aIntermediaryCompanyService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<IntermediaryCompanyResponseDto> getIntermediaryCompany(){
        return intermediarycompanyService.getAllIntermediaryCompany();
    }

    @GetMapping("/{nip}")
    @ResponseStatus(HttpStatus.OK)
    public IntermediaryCompanyResponseDto getIntermediaryCompanyByNip(@PathVariable String nip){
        return intermediarycompanyService.getIntermediaryCompanyByNip(nip);
    }

    @DeleteMapping("/{nip}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteIntermediaryCompanyByNip(@RequestParam String nip){
        return intermediarycompanyService.deleteIntermediaryCompanyByNip(nip);
    }

}
