package br.com.locatech.locatech.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI Locatech(){
        return new OpenAPI().info(
                new Info().title("Locatech - API").description("Destinada para aluguel de veiculos").version("v.0.1").license(new License().name("Apache2.0").url("github.com/vitorLevi17"))
        );
    }
}
