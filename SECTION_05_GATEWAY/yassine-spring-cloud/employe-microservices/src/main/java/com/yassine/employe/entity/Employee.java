package com.yassine.employe.entity;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int   idEmploye;
    private String nomEmploye;
    private String prenomEmploye;
    private String posteEmploye ;
    private Date dateEmbauche ;
    private int salaire;
    private  String  email;
    private  String  telephone;
    private  String  adresse;

    private int idGraEmp;


    @Override
    public String toString() {
        return "Employee [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
                + ", posteEmploye=" + posteEmploye + ", dateEmbauche=" + dateEmbauche + ", salaire=" + salaire
                + ", email=" + email + ", telephone=" + telephone + ", adresse=" + adresse +"]";
    }


}
