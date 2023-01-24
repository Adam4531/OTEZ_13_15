package pl.otez.technicalfault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.otez.event.dto.EventDto;
import pl.otez.technicalfault.dto.TechnicalFaultDto;

import java.util.List;

@Service
public class TechnicalFaultService {
    private final TechnicalFaultRepository technicalFaultRepository;
    private final TechnicalFaultMapper technicalFaultMapper;

    @Autowired
    public TechnicalFaultService(TechnicalFaultRepository aTechnicalFaultRepository, TechnicalFaultMapper aTechnicalFaultMapper) {
        technicalFaultRepository = aTechnicalFaultRepository;
        technicalFaultMapper = aTechnicalFaultMapper;
    }

    public TechnicalFaultEntity getTechnicalEntityById(Long id){
        return technicalFaultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Technical Fault with id:" + id + "does not exist"));
    }

    List<TechnicalFaultDto> getAllTechnicalFaults(){
        List<TechnicalFaultEntity> technicalFaultEntities = technicalFaultRepository.findAll();
        return technicalFaultMapper.fromTechnicalFaultEntityListToTechnicalFaultDtoList(technicalFaultEntities);
    }

    TechnicalFaultDto findTechnicalFaultById(Long id){
        return technicalFaultMapper.fromTechnicalFaultEntityToTechnicalFaultDto(getTechnicalEntityById(id));
    }

    TechnicalFaultDto addTechnicalFault(TechnicalFaultEntity aTechnicalFaultEntity){
        TechnicalFaultEntity savedEntity = technicalFaultRepository.save(aTechnicalFaultEntity);
        return technicalFaultMapper.fromTechnicalFaultEntityToTechnicalFaultDto(aTechnicalFaultEntity);
    }

    TechnicalFaultDto updateTechnicalFault(Long id, TechnicalFaultEntity aTechnicalFaultEntity){
        final TechnicalFaultEntity technicalEntity = getTechnicalEntityById(id);
        technicalFaultRepository.save(aTechnicalFaultEntity);
        return technicalFaultMapper.fromTechnicalFaultEntityToTechnicalFaultDto(aTechnicalFaultEntity);
    }

    void deleteById(Long id){
        technicalFaultRepository.deleteById(id);
    }
}
