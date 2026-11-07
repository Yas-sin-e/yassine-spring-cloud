package com.yassine.employe.service;

import com.yassine.employe.dto.GradeDto;
import org.springframework.stereotype.Component;

@Component
public class DeptFallBack implements  APIClient{

    @Override
    public GradeDto getGradeById(int id) {
        return null;
    }
}
