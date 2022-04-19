package com.axonactive.jpa.service;

import com.axonactive.jpa.entities.HealthInsurance;
import com.axonactive.jpa.service.dto.HealthInsuranceDTO;

import java.util.List;

public interface HealthInsuranceService {
    List<HealthInsurance> getAllHealthInsurance();

    List<HealthInsuranceDTO> getHealthInsuranceByEmployeeId(int employeeId);

    HealthInsuranceDTO getHealthInsuranceByEmployeeIdAndHealthInsuranceId(int employeeId, int healthInsuranceId);

    HealthInsuranceDTO addHealthInsurance(int employeeId, HealthInsuranceDTO healthInsuranceDTO);

    void deleteHealthInsuranceByEmployeeIdAndHealthInsuranceId(int employeeId, int healthInsuranceId);

    HealthInsuranceDTO updateHealthInsurance(int employeeId, int healthInsuranceId, HealthInsuranceDTO healthInsuranceDTO);
}
