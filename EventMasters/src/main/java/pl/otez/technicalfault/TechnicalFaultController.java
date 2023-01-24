package pl.otez.technicalfault;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.otez.technicalfault.dto.TechnicalFaultDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/technicalfaults")
public class TechnicalFaultController {

    private final TechnicalFaultService technicalFaultService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<TechnicalFaultDto> getAllTechnicalFaults(){
        return technicalFaultService.getAllTechnicalFaults();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TechnicalFaultDto getTechnicalFaultById(@PathVariable Long id){
        return technicalFaultService.findTechnicalFaultById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public TechnicalFaultDto addTechnicalFault(@RequestBody TechnicalFaultEntity aTechnicalFaultEntity){
        return technicalFaultService.addTechnicalFault(aTechnicalFaultEntity);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<TechnicalFaultDto> updateTechnicalFault(@PathVariable Long id, @RequestBody TechnicalFaultEntity aTechnicalFaultEntity){
        TechnicalFaultDto technicalFaultDto = technicalFaultService.updateTechnicalFault(id, aTechnicalFaultEntity);

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "Technical fault with id" + aTechnicalFaultEntity.getId() + " has been successfully updated");
        return new ResponseEntity<>(technicalFaultDto,httpHeaders,HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<TechnicalFaultDto> deleteTechnicalFault(@PathVariable Long id){
        technicalFaultService.deleteById(id);

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("HEADER", "Technical fault with id" + id + " has been successfully updated");
        return new ResponseEntity<>(httpHeaders,HttpStatus.ACCEPTED);
    }
}
