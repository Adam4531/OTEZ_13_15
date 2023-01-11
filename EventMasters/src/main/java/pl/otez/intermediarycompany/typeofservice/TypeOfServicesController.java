package pl.otez.intermediarycompany.typeofservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.otez.intermediarycompany.dto.IntermediaryCompanyResponseDto;
import pl.otez.intermediarycompany.typeofservice.dto.TypeOfServicesResponseDto;

import java.util.List;

@RestController
@RequestMapping("/typeofservices")
public class TypeOfServicesController {
    private TypeOfServicesService typeofservicesService;

    @Autowired
    TypeOfServicesController(TypeOfServicesService aTypeOfServicesService){
        typeofservicesService = aTypeOfServicesService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TypeOfServicesResponseDto> getTypeOfServices(){
        return typeofservicesService.getAllTypeOfServices();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TypeOfServicesResponseDto getTypeOfServicesById(@PathVariable Long id){
        return typeofservicesService.getTypeOfServicesById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteTypeOfServicesById(@RequestParam Long id){
        return typeofservicesService.deleteTypeOfServicesById(id);
    }
}
