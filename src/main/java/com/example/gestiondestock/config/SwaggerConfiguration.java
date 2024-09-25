package com.example.gestiondestock.config;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;


import static com.example.gestiondestock.utils.Constants.APP_ROOT;

@Configuration
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
