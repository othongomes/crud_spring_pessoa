package br.com.crud_spring_pessoa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.crud_spring_pessoa.Model.Pessoa;
import br.com.crud_spring_pessoa.repository.PessoaRepository;

@SpringBootApplication
public class CrudSpringPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringPessoaApplication.class, args);
	}

	@Bean //Spring gerencia o ciclo de vida
	CommandLineRunner initDatabase(PessoaRepository pessoaRepository) {
		return args -> {
			pessoaRepository.deleteAll();

			Pessoa c = new Pessoa();
			c.setNome("othon");;
			c.setEmail("othon@gmail.com");

			pessoaRepository.save(c);
		};
	}

}
