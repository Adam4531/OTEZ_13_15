package pl.otez.intermediarycompany.typeofservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.otez.intermediarycompany.IntermediaryCompanyEntity;
import pl.otez.intermediarycompany.dto.IntermediaryCompanyResponseDto;
import pl.otez.intermediarycompany.typeofservice.dto.TypeOfServicesResponseDto;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TypeOfServicesService {
    private final TypeOfServicesMapper typeofservicesMapper;
    private final TypeOfServicesRepository typeofservicesRepository;

    @Autowired
    public TypeOfServicesService(TypeOfServicesMapper aTypeOfServicesMapper, TypeOfServicesRepository aTypeOfServicesRepository){
        typeofservicesMapper= aTypeOfServicesMapper;
        typeofservicesRepository = aTypeOfServicesRepository;
    }
    public List<TypeOfServicesResponseDto> getAllTypeOfServices(){
        var TypeOfServices = typeofservicesRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return typeofservicesMapper.fromTypeOfServicesEntityListToTypeOfServicesResponseDto(TypeOfServices);
    }
    public TypeOfServicesEntity getTypeOfServices(Long id){
        return typeofservicesRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("Type of services with id" + id + " does not exist!"));
    }
    public TypeOfServicesResponseDto getTypeOfServicesById(Long id){
        TypeOfServicesEntity TypeOfServices = getTypeOfServices(id);
        return typeofservicesMapper.fromTypeOfServicesEntityToTypeOfServicesResponseDto(TypeOfServices);
    }

    public TypeOfServicesResponseDto updateTypeOfServicesName(Long id, String name){
        TypeOfServicesEntity TypeOfServices = getTypeOfServices(id);
        TypeOfServices.changeName(name);
        typeofservicesRepository.save(TypeOfServices);
        return typeofservicesMapper.fromTypeOfServicesEntityToTypeOfServicesResponseDto(TypeOfServices);
    }

    public String deleteTypeOfServicesById(Long id){
        TypeOfServicesEntity TypeOfServices = getTypeOfServices(id);
        typeofservicesRepository.delete(TypeOfServices);
        return "Type of services with id:" + id + " has been succesfully deleted!";
    }

}
