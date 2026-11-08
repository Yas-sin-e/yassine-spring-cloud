package com.yassine.employe.functions;

import com.yassine.employe.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;


@Configuration
public class EmployeeFunctions {
    private static final Logger log = LoggerFactory.getLogger(EmployeeFunctions.class);

    @Bean
    public Consumer<Integer> updateCommunication(EmployeeService EmployeeServiceService) {
        return employeeId -> {
            log.info("Updating Communication status for the teacher Id : " + employeeId.toString());
            EmployeeServiceService.updateCommunicationStatus(employeeId);

        };
    }
}
