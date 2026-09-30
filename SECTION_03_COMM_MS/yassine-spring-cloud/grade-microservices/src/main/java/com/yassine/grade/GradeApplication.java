package com.yassine.grade;

import com.yassine.grade.entity.Grade;
import com.yassine.grade.repos.GradeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	CommandLineRunner commandLineRunner(GradeRepository gradeRepository) {
		return args -> {
			gradeRepository.save(Grade.builder()
					.nomGraEmp("Master")
					.niveau("1")
					.build());

		gradeRepository.save(Grade.builder()
				.nomGraEmp("grandmaster")
				.niveau("2")
				.build());
	};
	}
}
