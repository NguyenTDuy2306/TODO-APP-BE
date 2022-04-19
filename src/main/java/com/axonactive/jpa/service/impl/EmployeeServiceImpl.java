package com.axonactive.jpa.service.impl;

import com.axonactive.jpa.controller.EmployeeController;
import com.axonactive.jpa.controller.request.EmployeeRequest;
import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.entities.Employee;
import com.axonactive.jpa.service.DepartmentService;
import com.axonactive.jpa.service.EmployeeService;
import com.axonactive.jpa.service.dto.EmployeeDTO;
import com.axonactive.jpa.service.dto.EmployeeWithDepartmentDTO;
import com.axonactive.jpa.service.mapper.DepartmentMapper;
import com.axonactive.jpa.service.mapper.EmployeeMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
//import java.util.logging.Level;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@RequestScoped
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);
    @Inject
    DepartmentMapper departmentMapper;


    @Inject
    @PersistenceContext(unitName = "jpa")
    static
    EntityManager em;

    @Inject
    EmployeeMapper employeeMapper;

    @Inject
    DepartmentService departmentService;

    @Override
    public List<EmployeeDTO> getAllEmployeeByDepartment(int departmentId) {
        TypedQuery<Employee> namedQuery = em.createNamedQuery(Employee.GET_ALL_BY_DEPT_ID_AND_EMPLOYEE_ID, Employee.class);
        namedQuery.setParameter("departmentId", departmentId);
        List<Employee> employeeList = namedQuery.getResultList();
        return employeeMapper.EmployeesToEmployeeDtos(employeeList);
    }


    private List<Employee> getEmployeeList() {
        return em.createNamedQuery(Employee.GET_ALL, Employee.class).getResultList();
    }

    @Override
    public EmployeeDTO getEmployeeById(int employeeId){
        return employeeMapper.EmployeeToEmployeeDto(getEmployeeByIdFromDataBase(employeeId));

    }

    @Override
    public Employee getEmployeeByIdFromDataBase(int employeeId){
        return em.find(Employee.class, employeeId);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeMapper.EmployeesToEmployeeDtos(getEmployeeList());
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.EmployeeRequestToEmployee(employeeRequest);
        employee.setDepartment(departmentService.getDepartmentById(employeeRequest.getDepartmentId()));
        em.persist(employee);
        return employeeMapper.EmployeeToEmployeeDto(employee);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        Employee employee = getEmployeeByIdFromDataBase(employeeId);
        if(Objects.nonNull(employee)) em.remove(employee);
    }

    @Override
    public EmployeeDTO updateEmployeeById(int employeeId, EmployeeRequest employeeRequest) {
        Employee employee = getEmployeeByIdFromDataBase(employeeId);
        if(Objects.nonNull(employee)){
            employee.setFirstName(employeeRequest.getFirstName());
            employee.setMiddleName(employeeRequest.getMiddleName());
            employee.setLastName(employeeRequest.getLastName());
            employee.setDateOfBirth(employeeRequest.getDateOfBirth());
            employee.setGender(employeeRequest.getGender());
            employee.setSalary(employeeRequest.getSalary());
            employee.setDepartment(departmentService.getDepartmentById(employeeRequest.getDepartmentId()));
            return employeeMapper.EmployeeToEmployeeDto(em.merge(employee));
        }
        throw new WebApplicationException(Response.status(BAD_REQUEST).entity("Không có Employee với Id: "+employeeId).build());
    }

    @Override
    public List<Employee> getAllEmployee (){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> from = cq.from(Employee.class);
        cq.select(from);
        TypedQuery<Employee> q = em.createQuery(cq);
        List<Employee> allEmployee = q.getResultList();
        LOGGER.info("Employee: {}", allEmployee);
        return allEmployee;
    }

    @Override
    public List<EmployeeWithDepartmentDTO> getEmployeeWithDepartmentIfo() {
        return getAllEmployee()
                .stream()
                .map(employee -> {
                    Department department = em.find(Department.class, employee.getDepartment().getId());
                    return new EmployeeWithDepartmentDTO(employeeMapper.EmployeeToEmployeeDto(employee), departmentMapper.departmentToDepartmentDto(department));
                }).collect(Collectors.toList());
    }

}
