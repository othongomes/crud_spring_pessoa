package br.com.crud_spring_pessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.crud_spring_pessoa.Model.Pessoa;
import br.com.crud_spring_pessoa.repository.PessoaRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class PersonService {

    private final PessoaRepository pessoaRepository;

    public PersonService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> getPessoaById(@PathVariable @NotNull @Positive Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa createPessoa(@Valid Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> updatePessoa(@Valid @NotNull @Positive Long id, Pessoa pessoaDetails) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(pessoaDetails.getNome());
                    pessoa.setGenero(pessoaDetails.getGenero());
                    pessoa.setNascimento(pessoaDetails.getNascimento());
                    pessoa.setEmail(pessoaDetails.getEmail());
                    pessoa.setCpf(pessoaDetails.getCpf());
                    return pessoaRepository.save(pessoa);

                });
    }

    public boolean deletePessoa(@PathVariable @NotNull @Positive Long id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoaRepository.delete(pessoa);
                    return true;
                })
                .orElse(false);
    }

}