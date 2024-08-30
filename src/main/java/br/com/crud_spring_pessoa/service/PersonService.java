package br.com.crud_spring_pessoa.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.crud_spring_pessoa.dto.PessoaDTO;
import br.com.crud_spring_pessoa.dto.mapper.PessoaMapper;
import br.com.crud_spring_pessoa.exception.RecordNotFoundException;
import br.com.crud_spring_pessoa.repository.PessoaRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class PersonService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PersonService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    public List<PessoaDTO> getAllPessoas() {
        return pessoaRepository.findAll()
        .stream()
        //.map(pessoa -> pessoaMapper.toDTO(pessoa))
        .map(pessoaMapper::toDTO)
        //.collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
        .collect(Collectors.toList());
    }

    public PessoaDTO getPessoaById(@PathVariable @NotNull @Positive Long id) {
        return pessoaRepository.findById(id).map(pessoaMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public PessoaDTO createPessoa(@Valid @NotNull PessoaDTO pessoa) {
        return pessoaMapper.toDTO(pessoaRepository.save(pessoaMapper.toEntity(pessoa)));
    }

    public PessoaDTO updatePessoa(@Valid @NotNull @Positive Long id, 
                                    @Valid @NotNull PessoaDTO pessoaDetails) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(pessoaDetails.nome());
                    pessoa.setGenero(pessoaDetails.genero());
                    pessoa.setNascimento(pessoaDetails.nascimento());
                    pessoa.setEmail(pessoaDetails.email());
                    pessoa.setCpf(pessoaDetails.cpf());
                    //return pessoaRepository.save(pessoa); //ou
                    return pessoaMapper.toDTO(pessoaRepository.save(pessoa));
                })
                //.map(pessoaMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void deletePessoa(@PathVariable @NotNull @Positive Long id) {
        pessoaRepository.delete(pessoaRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

}
