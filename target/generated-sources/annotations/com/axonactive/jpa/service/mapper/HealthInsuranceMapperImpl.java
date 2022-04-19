package com.axonactive.jpa.service.mapper;

import com.axonactive.jpa.entities.HealthInsurance;
import com.axonactive.jpa.service.dto.HealthInsuranceDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T14:58:24+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
public class HealthInsuranceMapperImpl implements HealthInsuranceMapper {

    @Override
    public HealthInsuranceDTO HealthInsuranceToHealthInsuranceDTO(HealthInsurance healthInsurance) {
        if ( healthInsurance == null ) {
            return null;
        }

        HealthInsuranceDTO healthInsuranceDTO = new HealthInsuranceDTO();

        healthInsuranceDTO.setId( healthInsurance.getId() );
        healthInsuranceDTO.setCode( healthInsurance.getCode() );
        healthInsuranceDTO.setAddress( healthInsurance.getAddress() );
        healthInsuranceDTO.setRegisterHospital( healthInsurance.getRegisterHospital() );
        healthInsuranceDTO.setExpirationDate( healthInsurance.getExpirationDate() );

        return healthInsuranceDTO;
    }

    @Override
    public List<HealthInsuranceDTO> HealthInsurancesToHealthInsuranceDTOs(List<HealthInsurance> healthInsuranceList) {
        if ( healthInsuranceList == null ) {
            return null;
        }

        List<HealthInsuranceDTO> list = new ArrayList<HealthInsuranceDTO>( healthInsuranceList.size() );
        for ( HealthInsurance healthInsurance : healthInsuranceList ) {
            list.add( HealthInsuranceToHealthInsuranceDTO( healthInsurance ) );
        }

        return list;
    }

    @Override
    public HealthInsurance HealthInsuranceDTOToHealthInsurance(HealthInsuranceDTO healthInsuranceDTO) {
        if ( healthInsuranceDTO == null ) {
            return null;
        }

        HealthInsurance healthInsurance = new HealthInsurance();

        healthInsurance.setId( healthInsuranceDTO.getId() );
        healthInsurance.setCode( healthInsuranceDTO.getCode() );
        healthInsurance.setAddress( healthInsuranceDTO.getAddress() );
        healthInsurance.setRegisterHospital( healthInsuranceDTO.getRegisterHospital() );
        healthInsurance.setExpirationDate( healthInsuranceDTO.getExpirationDate() );

        return healthInsurance;
    }
}
