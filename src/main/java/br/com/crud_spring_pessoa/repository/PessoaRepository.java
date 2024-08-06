package br.com.crud_spring_pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crud_spring_pessoa.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
