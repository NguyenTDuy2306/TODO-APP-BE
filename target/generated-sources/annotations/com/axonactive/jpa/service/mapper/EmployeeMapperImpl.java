package com.axonactive.jpa.service.mapper;

import com.axonactive.jpa.controller.request.EmployeeRequest;
import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.entities.Employee;
import com.axonactive.jpa.service.dto.EmployeeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T14:58:24+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO EmployeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        Integer id = employeeDepartmentId( employee );
        if ( id != null ) {
            employeeDTO.setDepartmentId( id );
        }
        employeeDTO.setId( employee.getId() );
        employeeDTO.setDateOfBirth( employee.getDateOfBirth() );
        employeeDTO.setGender( employee.getGender() );
        employeeDTO.setSalary( employee.getSalary() );

        getFullName( employee, employeeDTO );

        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> EmployeesToEmployeeDtos(List<Employee> employeeList) {
        if ( employeeList == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employeeList.size() );
        for ( Employee employee : employeeList ) {
            list.add( EmployeeToEmployeeDto( employee ) );
        }

        return list;
    }

    @Override
    public Employee EmployeeRequestToEmployee(EmployeeRequest employeeRequest) {
        if ( employeeRequest == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setFirstName( employeeRequest.getFirstName() );
        employee.setMiddleName( employeeRequest.getMiddleName() );
        employee.setLastName( employeeRequest.getLastName() );
        employee.setDateOfBirth( employeeRequest.getDateOfBirth() );
        employee.setGender( employeeRequest.getGender() );
        employee.setSalary( employeeRequest.getSalary() );

        return employee;
    }

    private Integer employeeDepartmentId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Department department = employee.getDepartment();
        if ( department == null ) {
            return null;
        }
        Integer id = department.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
