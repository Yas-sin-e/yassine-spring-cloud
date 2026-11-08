package com.yassine.employe.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmployeeDto {

    private Integer idEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private String posteEmploye;
    private Date dateEmbauche;
    private Integer salaire;
    private String email;
    private String telephone;
    private String adresse;

    // Attributs pour la communication
    private Integer idGraEmp;
    private String nomGraEmp;


}