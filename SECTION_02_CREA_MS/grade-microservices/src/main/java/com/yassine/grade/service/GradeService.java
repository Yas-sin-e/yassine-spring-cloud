package com.yassine.grade.service;

import com.yassine.grade.dto.GradeDto;
import com.yassine.grade.entity.Grade;

public interface GradeService {
    GradeDto getGradeById(int id);

    GradeDto convertEntityToDto(Grade g);

}
