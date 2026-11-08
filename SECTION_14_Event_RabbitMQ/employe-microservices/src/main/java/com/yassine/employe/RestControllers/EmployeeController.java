package com.yassine.employe.RestControllers;


import com.yassine.employe.config.Configuration;
import com.yassine.employe.dto.APIResponseDto;
import com.yassine.employe.dto.EmployeeDto;
import com.yassine.employe.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //trasfomer les retoure en json pret pour angular
@RequestMapping("/api/employes")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.createEmployee(employeeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Employee created successfully");
    }

    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") int id) {
        return new ResponseEntity<APIResponseDto>(
                employeeService.getEmployeeById(id),
                HttpStatus.OK
        );
    }
//    @Autowired
//    Configuration configuration;
//    @GetMapping("/author")
//    public ResponseEntity<String> retrieveAuthorInfo() {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(configuration.getName()+" "+configuration.getEmail() );
//    }


}
