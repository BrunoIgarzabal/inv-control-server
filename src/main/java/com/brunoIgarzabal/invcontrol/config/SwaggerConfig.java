package com.brunoIgarzabal.invcontrol.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${application-description}") String appDescription;
    @Value("${application-version}") String appVersion;

    private SecurityScheme jwtScheme() {
        return HttpAuthenticationScheme.JWT_BEARER_BUILDER
                .name("JWT")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(List.of(defaultAuth()))
                .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                .build();
    }

    private SecurityReference defaultAuth() {
        return SecurityReference.builder()
                .scopes(new AuthorizationScope[0])
                .reference("JWT")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(jwtScheme()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Inv Control API",
                appDescription,
                appVersion,
                "Terms of service",
                new Contact("Bruno Igarzabal", "brunoigarzabal.com", "brunoigar@live.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

}
