package com.cts.Productmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .build().apiInfo(apiDetails());
    }
    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Product Management API",
                "All API for Product Management",
                "1.1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Debraj Som","","debraj.som@Cognizant.com"),
                "API License",
                "",
                Collections.emptyList());
    }
}
