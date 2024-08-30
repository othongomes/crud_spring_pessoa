package br.com.crud_spring_pessoa.Model;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE Pessoa SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Long id;

    @NotNull
    @Column(nullable = false)
    @NotBlank(message = "O gênero é obrigatório")
    @Pattern(regexp = "M|F")
    private String genero;

    @NotNull
    @Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Length(min = 3, max = 100)
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "A idade é obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate nascimento;
    
    @NotNull
    @Column(nullable = false, unique = true)
    @Email(message = "Email deve ser válido")
    @NotBlank(message = "O email é obrigatório")
    @Length(max = 100)
    private String email;

    @NotNull
    @Column(nullable = false, unique = true)
    //@CPF(message = "CPF inválido")
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @NotNull
    @Column(length = 10,nullable = false)
    @Pattern(regexp = "Ativo|Inativo")
    private String status = "Ativo";
    
    
}
