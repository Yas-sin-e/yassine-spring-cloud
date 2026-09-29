package com.yassine.employe.service;

import com.yassine.employe.dto.GradeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//Tu ne fais que déclarer la signature de l'API distante sans écrire aucune ligne de code d'implémentation.
@FeignClient(url = "http://localhost:8080", value = "GRADE") //la value de Grade c'est lapplication name
public interface APIClient {

    @GetMapping("/api/Grade/{id}")
    GradeDto getGradeById(@PathVariable("id") int id);
}