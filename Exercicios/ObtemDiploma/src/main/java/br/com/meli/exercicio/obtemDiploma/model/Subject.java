package br.com.meli.exercicio.obtemDiploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Size(min = 8, max = 50, message = "O campo subject deve ter entre 8 a 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "O campo subject deve ser preenchido apenas com letras")
    private String subject;

    @Size(min = 1, max = 2, message = "O campo note conter entre 1 a 2 dígitos")
    @Pattern(regexp = "^[0-9]+$", message = "O campo note deve conter apenas números")
    private Double note;
}
