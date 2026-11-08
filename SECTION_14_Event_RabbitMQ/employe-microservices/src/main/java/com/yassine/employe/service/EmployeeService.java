package com.yassine.employe.service;

import com.yassine.employe.dto.APIResponseDto;
import com.yassine.employe.dto.EmployeeDto;
import com.yassine.employe.entity.Employee;

import java.util.List;

public interface EmployeeService {

    APIResponseDto getEmployeeById(int id);
    boolean updateCommunicationStatus(Integer employeeId);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto convertEntityToDto(Employee e);
    void createEmployee(EmployeeDto employeeDto);
    Employee convertDtoToEntity(EmployeeDto dto);
}