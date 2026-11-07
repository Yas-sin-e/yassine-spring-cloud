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

    private int idEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private String posteEmploye;
    private Date dateEmbauche;
    private int salaire;
    private String email;
    private String telephone;
    private String adresse;

    // Attributs pour la communication
    private int idGraEmp;
    private   String nomGraEmp;


}