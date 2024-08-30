package br.com.crud_spring_pessoa.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.crud_spring_pessoa.Model.Pessoa;
import br.com.crud_spring_pessoa.dto.PessoaDTO;
import br.com.crud_spring_pessoa.enums.Category;

@Component
public class PessoaMapper {

    public PessoaDTO toDTO(Pessoa pessoa) {

        if (pessoa == null) {
            return null;
        }
        
        return new PessoaDTO(pessoa.getId(), "M", pessoa.getNome(), pessoa.getNascimento(), pessoa.getEmail(), pessoa.getCpf());
    }

    public Pessoa toEntity(PessoaDTO pessoaDTO) {

        if (pessoaDTO == null) {
            return null;
        }

        Pessoa pessoa = new Pessoa();
        if (pessoaDTO.id() != null) {
            pessoa.setId(pessoaDTO.id());
        }
        pessoa.setGenero(Category.F);
        pessoa.setNome(pessoaDTO.nome());
        pessoa.setNascimento(pessoaDTO.nascimento());
        pessoa.setEmail(pessoaDTO.email());
        pessoa.setCpf(pessoaDTO.cpf());
        return pessoa;
    }
    
}
