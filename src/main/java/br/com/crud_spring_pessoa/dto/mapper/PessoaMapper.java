package br.com.crud_spring_pessoa.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crud_spring_pessoa.Model.Pessoa;
import br.com.crud_spring_pessoa.dto.PessoaDTO;
import br.com.crud_spring_pessoa.dto.PhoneDTO;
import br.com.crud_spring_pessoa.enums.Category;

@Component
public class PessoaMapper {

    public PessoaDTO toDTO(Pessoa pessoa) {

        if (pessoa == null) {
            return null;
        }
        
        List<PhoneDTO> phoneDTOs = pessoa.getPhones()
        .stream()
        .map(phone -> new PhoneDTO(phone.getId(), phone.getNumber(), phone.getType()))
        .collect(Collectors.toList());

        return new PessoaDTO(pessoa.getId(), pessoa.getGenero().getValue(), pessoa.getNome(), pessoa.getNascimento(), pessoa.getEmail(), pessoa.getCpf(), phoneDTOs);
    }

    public Pessoa toEntity(PessoaDTO pessoaDTO) {

        if (pessoaDTO == null) {
            return null;
        }

        Pessoa pessoa = new Pessoa();
        if (pessoaDTO.id() != null) {
            pessoa.setId(pessoaDTO.id());
        }
        pessoa.setGenero(convertCategotyValue(pessoaDTO.genero()));
        pessoa.setNome(pessoaDTO.nome());
        pessoa.setNascimento(pessoaDTO.nascimento());
        pessoa.setEmail(pessoaDTO.email());
        pessoa.setCpf(pessoaDTO.cpf());
        return pessoa;
    }

    public Category convertCategotyValue(String value) {

        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Masculino" -> Category.M;
            case "Feminino" -> Category.F;
            default -> throw new IllegalArgumentException("Invalid value");
        };
    }
    
}
