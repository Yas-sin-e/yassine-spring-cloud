package com.yassine.employe;

import com.yassine.employe.entity.Employee;
import com.yassine.employe.repos.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient; // Ligne à ajouter

import java.util.Date;
@EnableFeignClients //Elle active le composant Feign au démarrage de Spring Boot.
@SpringBootApplication
public class EmployeMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeMicroservicesApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.save(Employee.builder()
                    .nomEmploye("ddddd")
                    .prenomEmploye("Yassine")
                    .posteEmploye("Développeur Fullstack")
                    .salaire(3500)
                    .email("yassine@gmail.com")
                    .telephone("22949944")
                    .adresse("Nabeul")
                    .dateEmbauche(new Date())
                    .idGraEmp(1)
                    .build());

            employeeRepository.save(Employee.builder()
                    .nomEmploye("Ben qqqqqAli")
                    .prenomEmploye("Ahmed")
                    .posteEmploye("Chef de projet")
                    .salaire(4500)
                    .email("ahmed@gmail.com")
                    .telephone("50123456")
                    .adresse("Tunis")
                    .dateEmbauche(new Date())
                    .idGraEmp(2)
                    .build());
        };
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}