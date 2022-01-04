package br.com.meli.exercicio.obtemDiploma.controller;

import br.com.meli.exercicio.obtemDiploma.model.Student;
import br.com.meli.exercicio.obtemDiploma.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/analyzeNotes")
    private ResponseEntity<?> obtemDiploma(@Valid @RequestBody Student student, UriComponentsBuilder uriBuilder){
        URI uri = uriBuilder.build().toUri();
        return studentService.getDiploma(student, uri);
    }
}
