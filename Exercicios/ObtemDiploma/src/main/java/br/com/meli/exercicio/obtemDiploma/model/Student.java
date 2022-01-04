package br.com.meli.exercicio.obtemDiploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @NotBlank(message = "O campo name deve ser preenchido")
    @NotNull(message = "O campo name não pode ser nulo")
    @Size(min = 8, max = 50, message = "O campo name deve ter entre 8 a 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "O campo name deve ser preenchido apenas com letras")
    private String name;

    @NotNull(message = "O campo subjects não pode ser nulo")
    private ArrayList<Subject> subjects;
}
