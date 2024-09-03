package br.com.crud_spring_pessoa.dto;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.crud_spring_pessoa.Model.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PessoaDTO(

    @JsonProperty("_id") 
    Long id,

    @NotNull 
    @NotBlank(message = "O gênero é obrigatório") 
    @Pattern(regexp = "M|F") 
    String genero,

    @NotNull
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Length(min = 3, max = 100)
    String nome,

    @NotNull(message = "A idade é obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate nascimento,

    @NotNull
    @Email(message = "Email deve ser válido")
    @NotBlank(message = "O email é obrigatório")
    @Length(max = 100)
    String email,

    @NotNull
    //@CPF(message = "CPF inválido")
    String cpf,

    List<Phone> phones
) {
    
}
