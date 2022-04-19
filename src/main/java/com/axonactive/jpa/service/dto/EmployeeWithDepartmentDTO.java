package com.axonactive.jpa.service.dto;

import com.axonactive.jpa.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeWithDepartmentDTO {
    EmployeeDTO employeeDTO;
    DepartmentDTO departmentDTO;

}
