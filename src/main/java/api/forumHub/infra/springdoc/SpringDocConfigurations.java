package api.forumHub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("ForumHub API")
                        .description("API Rest da aplicação ForumHub, contendo as funcionalidades de CRUD de topicos, respostas, cursos, além da autenticação e autorização de usuários. ")
                        .contact(new Contact()
                                .name("Priscila Carla")
                                .email("priscilacarlaxd.08@gmail.com")
                                .url("https://github.com/priscilacixd/forumHub"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));

    }
}
