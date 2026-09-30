package com.yassine.employe.service;

import com.yassine.employe.dto.APIResponseDto;
import com.yassine.employe.dto.EmployeeDto;
import com.yassine.employe.entity.Employee;

import java.util.List;

public interface EmployeeService {

    APIResponseDto getEmployeeById(int id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto convertEntityToDto(Employee e);

    Employee convertDtoToEntity(EmployeeDto dto);
}