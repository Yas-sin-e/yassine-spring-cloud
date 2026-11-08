package com.yassine.mesage.functions;

import com.yassine.mesage.EmployeeMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;



@Configuration
public class MessageFunctions {
    private static final Logger log =
            LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<EmployeeMessageDto,EmployeeMessageDto> email() {
        return employeeMsgDto -> {
            log.info("Sending email with the details : " +
                    employeeMsgDto.toString());
            return employeeMsgDto;
        };
    }

    @Bean
    public Function<EmployeeMessageDto,Long> sms() {
        //EmployeeMessageDto input et long c'est output
        //long ici c'est le id de employe quand on le fait le MAJ  par son id
        return employeeMsgDto -> {
            log.info("Sending sms with the details : " +
                    employeeMsgDto.toString());
            return employeeMsgDto.employeeId();
        };
    }
}
