package pl.otez.intermediarycompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.otez.intermediarycompany.dto.IntermediaryCompanyResponseDto;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IntermediaryCompanyService {

    private final IntermediaryCompanyMapper intermediarycompanyMapper;
    private final IntermediaryCompanyRepository intermediarycompanyRepository;

    @Autowired
    public IntermediaryCompanyService(IntermediaryCompanyMapper aIntermediaryCompanyMapper, IntermediaryCompanyRepository aIntermediaryCompanyRepository){
        intermediarycompanyMapper = aIntermediaryCompanyMapper;
        intermediarycompanyRepository = aIntermediaryCompanyRepository;
    }
    public List<IntermediaryCompanyResponseDto> getAllIntermediaryCompany(){
       var intermediaryCompany = intermediarycompanyRepository.findAll(Sort.by(Sort.Direction.ASC, "nip"));
       return intermediarycompanyMapper.fromIntermediaryCompanyEntityListToIntermediaryCompanyResponseDto(intermediaryCompany);
    }
    public IntermediaryCompanyEntity getIntermediaryCompany(String nip){
        return intermediarycompanyRepository.findById(Long.parseLong(nip)).
                orElseThrow(() -> new NoSuchElementException("Company with nip" + nip + " does not exist!"));
    }
    public IntermediaryCompanyResponseDto getIntermediaryCompanyByNip(String nip){
        IntermediaryCompanyEntity IntermediaryCompany = getIntermediaryCompany(nip);
        return intermediarycompanyMapper.fromIntermediaryCompanyEntityToIntermediaryCompanyResponseDto(IntermediaryCompany);
    }

    public IntermediaryCompanyResponseDto updateIntermediaryCompanynName(String nip, String nameOfCompany){
        IntermediaryCompanyEntity intermediaryCompany = getIntermediaryCompany(nip);
        intermediaryCompany.changeName(nameOfCompany);
        intermediarycompanyRepository.save(intermediaryCompany);
        return intermediarycompanyMapper.fromIntermediaryCompanyEntityToIntermediaryCompanyResponseDto(intermediaryCompany);
    }

    public String deleteIntermediaryCompanyByNip(String nip){
        IntermediaryCompanyEntity intermediarycompany = getIntermediaryCompany(nip);
        intermediarycompanyRepository.delete(intermediarycompany);
        return "Company with nip:" + nip + " has been succesfully deleted!";
    }
















}
