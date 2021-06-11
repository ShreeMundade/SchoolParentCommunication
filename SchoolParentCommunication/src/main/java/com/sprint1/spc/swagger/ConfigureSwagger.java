package com.sprint1.spc.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfigureSwagger {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("School Parent Communication").version("1.0").description("APP for managing school parent communication.")
				 .contact(new Contact("Student Parent", "http://www.schoolparent.com", "admin@schoolparent.com"))
	                .license("Apache License Version 2.0").build();
	}

}