package com.yassine.grade.RestControllers;

import com.yassine.grade.config.Configuration;
import com.yassine.grade.dto.GradeDto;
import com.yassine.grade.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Grade")
@RefreshScope // <--- Indispensable pour recharger les valeurs dynamiquement
public class GradeController {

    private GradeService gradeService;
    @Autowired
    private Configuration configuration;

    @Value("${build.version}")
    private String buildVersion;

    public  GradeController(GradeService gradeService){
        this.gradeService =  gradeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<GradeDto> getGradeByID(@PathVariable("id") int id) {
        return new ResponseEntity<GradeDto>(
                gradeService.getGradeById(id), HttpStatus.OK);
    }
    @GetMapping("/version")
    public ResponseEntity<String> version()
    {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName()+" "+configuration.getEmail() );
    }

}
