package br.com.crud_spring_pessoa.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.crud_spring_pessoa.Model.Pessoa;
import br.com.crud_spring_pessoa.dto.PessoaDTO;

@Component
public class PessoaMapper {

    public PessoaDTO toDTO(Pessoa pessoa) {

        if (pessoa == null) {
            return null;
        }
        
        return new PessoaDTO(pessoa.getId(), pessoa.getGenero(), pessoa.getNome(), pessoa.getNascimento(), pessoa.getEmail(), pessoa.getCpf());
    }

    public Pessoa toEntity(PessoaDTO pessoaDTO) {

        if (pessoaDTO == null) {
            return null;
        }

        Pessoa pessoa = new Pessoa();
        if (pessoaDTO.id() != null) {
            pessoa.setId(pessoaDTO.id());
        }
        pessoa.setGenero(pessoaDTO.genero());
        pessoa.setNome(pessoaDTO.nome());
        pessoa.setNascimento(pessoaDTO.nascimento());
        pessoa.setEmail(pessoaDTO.email());
        pessoa.setCpf(pessoaDTO.cpf());
        return pessoa;
    }
    
}