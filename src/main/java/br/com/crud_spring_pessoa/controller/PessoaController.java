package br.com.crud_spring_pessoa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud_spring_pessoa.dto.PessoaDTO;
import br.com.crud_spring_pessoa.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated // ativa @NotNull @Positive
@RestController
@RequestMapping("/api/pessoas")
// @AllArgsConstructor
public class PessoaController {

    // @Autowired
    private final PersonService personService;

    public PessoaController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public @ResponseBody List<PessoaDTO> getAllPessoas() {
        return personService.getAllPessoas();
    }

    @GetMapping("/{id}")
    public PessoaDTO getPessoaById(@PathVariable @NotNull @Positive Long id) {
        return personService.getPessoaById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PessoaDTO createPessoa(@Valid @RequestBody @NotNull PessoaDTO pessoa) {
        return personService.createPessoa(pessoa);
    }

    @PutMapping("/{id}")
    public PessoaDTO updatePessoa(@Valid @PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull PessoaDTO pessoaDetails) {
        return personService.updatePessoa(id, pessoaDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePessoa(@PathVariable @NotNull @Positive Long id) {
        personService.deletePessoa(id);
    }
}
