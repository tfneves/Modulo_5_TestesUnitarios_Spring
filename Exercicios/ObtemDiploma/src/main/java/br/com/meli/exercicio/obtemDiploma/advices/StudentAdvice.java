package br.com.meli.exercicio.obtemDiploma.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StudentAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<Map<String, String>> methodArgumentNotValid(MethodArgumentNotValidException e){
        Map<String, String> response = new HashMap<String, String>();
        for (ObjectError allError : e.getBindingResult().getAllErrors()) {
            response.put("errorMessage", allError.getDefaultMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return null;
    }
}
