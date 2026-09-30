package com.yassine.grade.service;

import com.yassine.grade.dto.GradeDto;
import com.yassine.grade.entity.Grade;
import com.yassine.grade.repos.GradeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements  GradeService {
    private GradeRepository gradeRepository;


    @Override
    public GradeDto getGradeById(int id) {
        return convertEntityToDto(gradeRepository.findById(id).orElse(null));
    }
    private ModelMapper modelMapper;

    @Override
    public GradeDto convertEntityToDto(Grade g) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        GradeDto dto = modelMapper.map(g, GradeDto.class);

        return dto;

    }
}
