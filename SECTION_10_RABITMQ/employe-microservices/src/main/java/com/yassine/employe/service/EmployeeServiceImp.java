package com.yassine.employe.service;

import com.yassine.employe.dto.APIResponseDto;
import com.yassine.employe.dto.EmployeeDto;
import com.yassine.employe.dto.GradeDto;
import com.yassine.employe.entity.Employee;
import com.yassine.employe.repos.EmployeeRepository;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class EmployeeServiceImp implements EmployeeService {


    private EmployeeRepository employeeRepository;
    private WebClient webClient;
    private ModelMapper modelMapper;
    private APIClient apiClient;
//    @Override
//    public EmployeeDto getEmployeeById(int id) {
//        return convertEntityToDto(
//                employeeRepository.findById(id).orElse(null)
//        );
//    }
@Override
public APIResponseDto getEmployeeById(int id) {
    // 1. Récupérer l'entité Employee depuis la base de données

    Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employé non trouvé avec l'id : " + id));

    GradeDto gradeDto = apiClient.getGradeById(employee.getIdGraEmp());

    // 2. Appeler le microservice Grade de manière sécurisée
//    GradeDto gradeDto = null;
//    try {
//        gradeDto = webClient.get()
//                .uri("http://localhost:8080/api/Grade/" + employee.getIdGraEmp())
//                .retrieve()  // Exécute la requête HTTP.
//                .bodyToMono(GradeDto.class) //Convertit le JSON reçu du microservice Grade en un objet Java
//                .block();// Attention : blocage synchrone pour attendre la réponse
//        //Transforme l'appel réactif asynchrone en un appel synchrone pour attendre le résultat avant d'exécuter la suite du code.
//    } catch (Exception e) {
//        System.err.println("Erreur lors de la récupération du grade (ID " + employee.getIdGraEmp() + ") : " + e.getMessage());
//    }

    // 3. Conversion de l'entité Employee vers EmployeeDto à l'aide de ModelMapper

    EmployeeDto employeeDto =convertEntityToDto(employee);
    if (gradeDto != null) {
        employeeDto.setNomGraEmp(gradeDto.getNomGraEmp());
    }
    // Si ton EmployeeDto contient aussi le nom du grade (nomGraEmp)


    // 4. Créer et remplir l'objet de réponse globale (APIResponseDto)
    APIResponseDto apiResponseDto = new APIResponseDto();
    apiResponseDto.setEmployeeDto(employeeDto);
    apiResponseDto.setGradeDto(gradeDto);

    return apiResponseDto;
}



    // GET ALL



    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto convertEntityToDto(Employee e) {

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        EmployeeDto dto = modelMapper.map(e, EmployeeDto.class);

        return dto;
    }

    @Override
    public Employee convertDtoToEntity(EmployeeDto dto) {

        Employee e = modelMapper.map(dto, Employee.class);

        return e;
    }
}