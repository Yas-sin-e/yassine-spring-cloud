package com.yassine.employe.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDto {
    private  int idGraEmp;
    private   String nomGraEmp;
    private String niveau ;

}
