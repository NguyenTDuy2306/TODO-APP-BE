package com.axonactive.jpa.service.mapper;

import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.service.dto.DepartmentDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T14:58:24+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDTO departmentToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setName( department.getName() );
        departmentDTO.setStartDate( department.getStartDate() );

        return departmentDTO;
    }
}
