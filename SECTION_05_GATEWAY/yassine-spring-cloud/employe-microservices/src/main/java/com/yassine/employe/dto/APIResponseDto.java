package com.yassine.employe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDto employeeDto;
    private GradeDto gradeDto;
}