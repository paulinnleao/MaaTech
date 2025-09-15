package com.maatech.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MaaTech - API de Busca de Produtos com IA")
                        .version("v1")
                        .description("A **MaaTech API** permite que usuários preencham um formulário para buscar produtos. " +
                                "A busca é processada pela IA Gemini, que retorna uma lista de produtos e uma descrição técnica " +
                                "resumida, com apresentação clara e visual para o cliente.\n\n" +
                                "### Rotas públicas disponíveis:\n" +
                                "- Registro de conta\n" +
                                "- Login\n" +
                                "- Busca de produtos via formulário\n\n" +
                                "As demais rotas são protegidas e requerem autenticação.")
                        .termsOfService("https://localhost:8080/terms")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://opensource.org/licenses/Apache-2.0")
                        )
                )
                .addTagsItem(new Tag().name("Auth").description("Endpoints de autenticação"))
                .addTagsItem(new Tag().name("Formulário").description("Busca de produtos via formulário"))
                .addTagsItem(new Tag().name("Produtos").description("Operações relacionadas a produtos"))

                // Configuração de segurança para Swagger UI
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("Authorization")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                );
    }
}
