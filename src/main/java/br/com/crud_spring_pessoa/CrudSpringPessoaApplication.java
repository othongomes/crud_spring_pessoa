package br.com.crud_spring_pessoa;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.crud_spring_pessoa.Model.Pessoa;
import br.com.crud_spring_pessoa.Model.Phone;
import br.com.crud_spring_pessoa.enums.Category;
import br.com.crud_spring_pessoa.repository.PessoaRepository;

@SpringBootApplication
public class CrudSpringPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringPessoaApplication.class, args);
	}

	@Bean //Spring gerencia o ciclo de vida
	CommandLineRunner initDatabase(PessoaRepository pessoaRepository) {
		return args -> {

			Pessoa c = new Pessoa();
			c.setGenero(Category.M);
			c.setNome("othon");
			c.setEmail("othon@gmail.com");
			c.setNascimento(LocalDate.of(1995, 9, 5));
			c.setCpf("1234567890");

			Phone phone = new Phone();
			phone.setNumber("1234567890");
			phone.setType("celular");
			phone.setPessoa(c);
			c.getPhones().add(phone);

			Phone phone1 = new Phone();
			phone1.setNumber("0987654321");
			phone1.setType("telefone");
			phone1.setPessoa(c);
			c.getPhones().add(phone1);

			pessoaRepository.save(c);

			Pessoa c1 = new Pessoa();
			c1.setGenero(Category.F);
			c1.setNome("maria");
			c1.setEmail("maria@gmail.com");
			c1.setNascimento(LocalDate.of(1984, 5, 7));
			c1.setCpf("1234567899");

			pessoaRepository.save(c1);

			Pessoa c2 = new Pessoa();
			c2.setGenero(Category.M);
			c2.setNome("jack");
			c2.setEmail("jack@hotmail.com");
			c2.setNascimento(LocalDate.of(2020, 7, 7));
			c2.setCpf("1234567898");

			pessoaRepository.save(c2);

		};
	}

}
