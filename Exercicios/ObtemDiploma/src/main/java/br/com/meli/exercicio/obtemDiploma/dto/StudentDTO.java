package br.com.meli.exercicio.obtemDiploma.dto;

import br.com.meli.exercicio.obtemDiploma.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String message;
    private Double average;
    private Student student;


    public static StudentDTO convert(Student studentModel){
        return StudentDTO.builder()
                .student(studentModel)
                .build();
    }
}
