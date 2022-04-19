package com.axonactive.jpa.service.mapper;

import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.service.dto.DepartmentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {
    DepartmentDTO departmentToDepartmentDto(Department department);
}
