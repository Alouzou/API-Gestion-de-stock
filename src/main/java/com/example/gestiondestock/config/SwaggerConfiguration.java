package com.example.gestiondestock.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "AmineO",
                        email = "amino@gmail.com"
                ),
                description = "OpenApi documentation pour gestion de stock",
                title = "OpenApi documentation gestion de stock",
                version = "1.0"

        ),
        servers =
        @Server(
                description = "LOCAL ENV",
                url = "http://localhost:8080"
        )
)
public class SwaggerConfiguration {


    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("gestiondestock")
                .pathsToMatch(APP_ROOT + "/**")
                .build();
    }
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(
//                        new ApiInfoBuilder()
//                                .description("Gestion de stock API documentation")
//                                .title("Gestion de stock REST API")
//                                .build()
//                )
//                .groupName("REST API V1")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.gestiondestock"))
//                .paths(PathSelectors.ant(APP_ROOT + "/**"))
//                .build();

}
