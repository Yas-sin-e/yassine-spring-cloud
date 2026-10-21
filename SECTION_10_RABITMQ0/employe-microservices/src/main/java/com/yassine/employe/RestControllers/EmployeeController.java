package com.yassine.employe.RestControllers;


import com.yassine.employe.config.authorConfig;
import com.yassine.employe.dto.APIResponseDto;
import com.yassine.employe.dto.EmployeeDto;
import com.yassine.employe.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController //trasfomer les retoure en json pret pour angular
@RequestMapping("/api/employes")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;


    private authorConfig authorConfig;


    static class EmployeeControllerConfiguration {

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
    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authorConfig.getName()+" "+authorConfig.getEmail() );
    }

}
