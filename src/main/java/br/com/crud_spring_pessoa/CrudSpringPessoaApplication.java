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
			c.setIdade(10);
			c.setCpf("47041299856");

			pessoaRepository.save(c);

			Pessoa c1 = new Pessoa();
			c1.setNome("maria");;
			c1.setEmail("maria@gmail.com");
			c1.setIdade(20);
			c1.setCpf("29499150862");

			pessoaRepository.save(c1);

		};
	}

}
