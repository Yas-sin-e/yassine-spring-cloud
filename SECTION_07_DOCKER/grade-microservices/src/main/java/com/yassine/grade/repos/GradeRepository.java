package com.yassine.grade.repos;

import com.yassine.grade.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GradeRepository extends JpaRepository<Grade, Integer> {
    Grade findByNomGraEmp(String nomGraEmp);
}