package com.yassine.grade.RestControllers;

import com.yassine.grade.dto.GradeDto;
import com.yassine.grade.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Grade")
@AllArgsConstructor
public class GradeController {

    private GradeService gradeService;

    @GetMapping("{id}")
    public ResponseEntity<GradeDto> getGradeByID(@PathVariable("id") int id) {
        return new ResponseEntity<GradeDto>(
                gradeService.getGradeById(id), HttpStatus.OK);
    }

}
