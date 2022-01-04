package br.com.meli.exercicio.obtemDiploma.service;

import br.com.meli.exercicio.obtemDiploma.dto.StudentDTO;
import br.com.meli.exercicio.obtemDiploma.model.Student;
import br.com.meli.exercicio.obtemDiploma.model.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class StudentService {

    /**
     * Retorna resposta da requisição
     *
     * @author Thomaz Ferreira
     * @param student
     * @param uri
     * @return ResponseEntity
     */
    public ResponseEntity<StudentDTO> getDiploma(Student student, URI uri){
        StudentDTO stdDto = StudentDTO.convert(student);
        double media = calculaMedia(stdDto);
        stdDto.setAverage(media);
        stdDto.setMessage("Sua média foi de " + media);
        return ResponseEntity.created(uri).body(stdDto);
    }

    /**
     * Calcula média das notas
     *
     * @author Thomaz Ferreira
     * @param stdDto
     * @return double
     */
    private double calculaMedia(StudentDTO stdDto){
        if(stdDto.getStudent().getSubjects().size() == 0)
            return 0;

        double media = 0;
        for(Subject s : stdDto.getStudent().getSubjects()){
            media += s.getNote();
        }
        return media/stdDto.getStudent().getSubjects().size();
    }
}
