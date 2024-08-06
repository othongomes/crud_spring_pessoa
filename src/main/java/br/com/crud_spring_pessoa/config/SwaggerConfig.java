package br.com.crud_spring_pessoa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API PESSOA")
                        .description("API CONTROLE DE PESSOAS (http://localhost:8080/swagger-ui/index.html#/)")
                        .version("1.0.0"));
    }
}
